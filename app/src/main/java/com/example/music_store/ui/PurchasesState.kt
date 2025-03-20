package com.example.music_store.ui

import com.example.music_store.model.Purchase

data class PurchasesState (
    val totalSum: Int = 0,
    val type: String = "string",
    val instruments: List<Purchase> = emptyList()
)