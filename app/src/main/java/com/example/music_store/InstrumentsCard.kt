package com.example.music_store

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.music_store.model.Instruments

@Composable
fun InstrumentsCard(
    instruments: Instruments,
    onCardClicked: (Instruments)-> Unit
    )
{
    Card(
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = Modifier.clickable {
            onCardClicked(instruments)
        }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = stringResource(instruments.name),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 25.sp
                )
            )
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(instruments.image),
                contentDescription = null
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}