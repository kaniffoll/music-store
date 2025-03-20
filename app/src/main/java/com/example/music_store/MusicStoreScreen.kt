package com.example.music_store

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.music_store.ui.PurchasesViewModel
import com.example.music_store.ui.UserViewModel

enum class MusicStoreScreen {
    Registration,
    Shop,
    Menu,
    Cart
}

@Composable
fun MusicStoreApp(
    viewModel: UserViewModel,
    navController: NavHostController = rememberNavController()
){
    val purchasesViewModel: PurchasesViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = MusicStoreScreen.Registration.name
    ){
        composable(route = MusicStoreScreen.Registration.name) {
            RegistrationScreen(
                viewModel = viewModel,
                registrationButtonClicked = {navController.navigate(MusicStoreScreen.Shop.name)}
                )
        }
        composable(route = MusicStoreScreen.Shop.name) {
            ShopList(
                onMenuButton = {navController.navigate(MusicStoreScreen.Menu.name)},
                purchasesViewModel = purchasesViewModel
            )
        }
        composable(route = MusicStoreScreen.Menu.name) {
            ShopMenu(
                viewModel = viewModel,
                onCatalogButton = {navController.navigate(MusicStoreScreen.Shop.name)},
                onCartButton = {navController.navigate(MusicStoreScreen.Cart.name)},
                onLogOutButton = {navController.navigate(MusicStoreScreen.Registration.name)}
            )
        }
        composable(route = MusicStoreScreen.Cart.name) {
            ShoppingCart(
                onMenuButtonClicked = {navController.navigate(MusicStoreScreen.Menu.name)},
                purchasesViewModel = purchasesViewModel
            )
        }
    }
}