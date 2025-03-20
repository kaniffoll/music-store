package com.example.music_store

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.music_store.model.Purchase

@Composable
fun ResultList(
    list: List<Pair<Purchase, Int>>,
) {
    LazyColumn {
        items(list){ item ->
            ResultsCard(item.first, item.second)
        }
    }
}