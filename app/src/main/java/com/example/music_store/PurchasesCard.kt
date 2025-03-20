package com.example.music_store

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.music_store.model.Purchase
import com.example.music_store.ui.PurchasesViewModel

@Composable
fun PurchasesCard(
    purchase: Purchase,
    purchasesViewModel: PurchasesViewModel
    )
{
    val count = purchasesViewModel.getCountForPurchase(purchase)
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
            Column {
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = stringResource(purchase.name),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = purchase.price.toString() + " $",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "-",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.clickable {
                            if(count>0){
                                purchasesViewModel.decreaseCount(purchase)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(7.dp))
                            .background(color = MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text =  count.toString(),
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "+",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.clickable {
                            if(count<9){
                                purchasesViewModel.updateCount(purchase)
                            }
                        }
                    )
                }
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

//@Preview()
//@Composable
//fun PurchasesCardPreview(){
//    PurchasesCard(purchase = Purchase(image = R.drawable.full_drum_kit, name = R.string.full_drums, 150))
//}