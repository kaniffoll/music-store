package com.example.music_store

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.music_store.model.Purchase

@Composable
fun ResultsCard(
    purchase: Purchase,
    count: Int
)
{
    Card(
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row {
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = stringResource(purchase.name) + "\t",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier=Modifier.width(5.dp))
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "x $count",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 18.sp
                    )
                )
            }
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(purchase.image),
                contentDescription = null
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}