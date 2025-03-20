package com.example.music_store

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.music_store.model.Instruments
import com.example.music_store.model.drumsInstruments
import com.example.music_store.model.keysInstruments
import com.example.music_store.model.stringInstruments

@Composable
fun InstrumentsList(
    type: String,
    onCardClicked: (Instruments)->Unit,
) {
    val instrumentsList = when(type){
        "drums" -> drumsInstruments
        "keys" -> keysInstruments
        else -> stringInstruments
    }
    LazyColumn {
        items(instrumentsList){ item ->
            InstrumentsCard(item, onCardClicked)
        }
    }
}