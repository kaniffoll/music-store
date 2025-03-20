package com.example.music_store

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.music_store.ui.PurchasesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCart(
    onMenuButtonClicked: () -> Unit,
    purchasesViewModel: PurchasesViewModel
){
    val context = LocalContext.current
    val newOrder = stringResource(R.string.new_order)
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.cart),
                        style = MaterialTheme.typography.headlineLarge,
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {onMenuButtonClicked()}) {
                        Icon(
                            painter = painterResource(R.drawable.menu_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { shareOrder(context, newOrder, "Total sum: " + purchasesViewModel.getTotalSum().toString() + " $")}) {
                        Icon(
                            painter = painterResource(R.drawable.share),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)){
                ResultList(purchasesViewModel.getAllPurchases())
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    text = stringResource(R.string.total_sum)+": \t ${purchasesViewModel.getTotalSum()} $",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.align(Alignment.BottomEnd).padding(end = 30.dp, bottom = 30.dp)
                )
            }
        }
    )
}

private fun shareOrder(context: Context, subject:String, summary: String){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.new_order)
        )
    )
}

//@Preview(showBackground = true)
//@Composable
//fun CartPreview(){
//    Music_storeTheme {
//        ShoppingCart(
//            onMenuButtonClicked = {}
//        )
//    }
//}