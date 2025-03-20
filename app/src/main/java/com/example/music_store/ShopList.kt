package com.example.music_store

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.music_store.ui.PurchasesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopList(
    onMenuButton: () -> Unit,
    purchasesViewModel: PurchasesViewModel
) {
    val state by purchasesViewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.catalog),
                        style = MaterialTheme.typography.headlineLarge
                    )
                },
                navigationIcon = {
                    if(state.instruments.isEmpty()){
                        IconButton(onClick = {onMenuButton()}) {
                            Icon(
                                painter = painterResource(R.drawable.menu_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                    }
                    else{
                        IconButton(onClick = {purchasesViewModel.updateInstruments(emptyList())}) {
                            Icon(
                                painter = painterResource(R.drawable.arrow_back),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
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
            if(state.instruments.isEmpty()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background)
                        .padding(innerPadding)
                        .padding(start = 5.dp, end = 5.dp, top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(bottom = 10.dp)
                            .border(
                                BorderStroke(2.dp, Color.Black),
                                shape = RoundedCornerShape(5.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = stringResource(R.string.string),
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontSize = 25.sp
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clickable(onClick = { purchasesViewModel.updateType("string") }),
                            maxLines = 1,
                            textAlign = TextAlign.Center
                        )
                        VerticalDivider(color = Color.Black, thickness = 3.dp)
                        Text(
                            text = stringResource(R.string.drums),
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontSize = 25.sp
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clickable(onClick = { purchasesViewModel.updateType("drums") }),
                            maxLines = 1,
                            textAlign = TextAlign.Center
                        )
                        VerticalDivider(color = Color.Black, thickness = 3.dp)
                        Text(
                            text = stringResource(R.string.keys),
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontSize = 25.sp
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clickable(onClick = { purchasesViewModel.updateType("keys") }),
                            maxLines = 1,
                            textAlign = TextAlign.Center
                        )
                    }
                    InstrumentsList(state.type) {
                        purchasesViewModel.updateInstruments(it.purchaseList)
                    }
                }
            }
            else{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background)
                        .padding(innerPadding)
                        .padding(start = 5.dp, end = 5.dp, top = 10.dp)
                ) {
                    PurchasesList(state.instruments, purchasesViewModel)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    text = stringResource(R.string.total_sum) + ": \t ${purchasesViewModel.getTotalSum()} $",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.align(Alignment.BottomEnd).padding(end = 30.dp, bottom = 30.dp)
                )
            }
        },
    )
}