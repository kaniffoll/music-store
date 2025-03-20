package com.example.music_store

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.music_store.model.Purchase
import com.example.music_store.ui.PurchasesViewModel

@Composable
fun PurchasesList(
    list: List<Purchase>,
    purchasesViewModel: PurchasesViewModel
) {
    LazyColumn {
        items(list){ item ->
            PurchasesCard(item,purchasesViewModel)
        }
    }
}