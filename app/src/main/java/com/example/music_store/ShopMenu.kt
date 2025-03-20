package com.example.music_store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.music_store.ui.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopMenu(
    viewModel: UserViewModel,
    onCatalogButton: () -> Unit,
    onCartButton: () -> Unit,
    onLogOutButton: () -> Unit
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.music_store),
                        style = MaterialTheme.typography.headlineLarge
                    )
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .padding(10.dp)
            ){
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {onCatalogButton()},
                    shape = RoundedCornerShape(size = 8.dp)
                ){
                    Text(
                        text = stringResource(R.string.catalog),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {onCartButton()},
                    shape = RoundedCornerShape(size = 8.dp)
                ){
                    Text(
                        text = stringResource(R.string.cart),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column {
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            viewModel.updateLogin("")
                            viewModel.updatePassword("")
                            onLogOutButton()
                        },
                        shape = RoundedCornerShape(size = 8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.log_out), color = Color.Red,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            viewModel.deleteUser()
                            onLogOutButton()
                        },
                        shape = RoundedCornerShape(size = 8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.delete_account), color = Color.Red,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                }
            }
        }
    )

}

//@Preview(showBackground = true)
//@Composable
//fun MenuPreview(){
//    Music_storeTheme {
//        ShopMenu()
//    }
//}