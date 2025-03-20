package com.example.music_store.ui

import androidx.lifecycle.ViewModel
import com.example.music_store.model.Purchase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PurchasesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PurchasesState())
    val uiState: StateFlow<PurchasesState> = _uiState.asStateFlow()

    private val categoryCounts: MutableMap<Int, Int> = mutableMapOf()
    private val categoryPrices: MutableMap<Int, Int> = mutableMapOf()

    private val allPurchases: MutableList<Pair<Purchase, Int>> = mutableListOf()

    fun updateType(newType: String) {
        _uiState.value = _uiState.value.copy(
            type = newType
        )
    }

    fun updateInstruments(newInstruments: List<Purchase>) {
        _uiState.value = _uiState.value.copy(instruments = newInstruments)
    }


    fun updateCount(purchase: Purchase) {
        val currentCount = categoryCounts[purchase.name] ?: 0
        categoryCounts[purchase.name] = currentCount + 1

        val currentPrice = categoryPrices[purchase.name] ?: 0
        categoryPrices[purchase.name] = currentPrice + purchase.price

        val existingIndex = allPurchases.indexOfFirst { it.first.name == purchase.name }
        if (existingIndex != -1) {
            allPurchases[existingIndex] = Pair(purchase, currentCount + 1)
        } else {
            allPurchases.add(Pair(purchase, 1))
        }

        updateTotalSum()
    }

    fun decreaseCount(purchase: Purchase) {
        val currentCount = categoryCounts[purchase.name] ?: 0
        if (currentCount > 0) {
            categoryCounts[purchase.name] = currentCount - 1

            val currentPrice = categoryPrices[purchase.name] ?: 0
            categoryPrices[purchase.name] = currentPrice - purchase.price

            val existingIndex = allPurchases.indexOfFirst { it.first.name == purchase.name }
            if (existingIndex != -1) {
                val newCount = currentCount - 1
                if (newCount > 0) {
                    allPurchases[existingIndex] = Pair(purchase, newCount)
                } else {
                    allPurchases.removeAt(existingIndex)
                }
            }
            updateTotalSum()
        }
    }

    private fun updateTotalSum() {
        val totalSum = categoryPrices.values.sum()
        _uiState.value = _uiState.value.copy(totalSum = totalSum)
    }

    fun getCountForPurchase(purchase: Purchase): Int {
        return categoryCounts[purchase.name] ?: 0
    }

    fun getTotalSum(): Int {
        return _uiState.value.totalSum
    }

    fun getAllPurchases(): List<Pair<Purchase, Int>> {
        return allPurchases
    }
}