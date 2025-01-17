package com.example.navtest.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

sealed class NavTestDestinations(val route: String) {
    data object Home : NavTestDestinations("home")

    data object ProductList : NavTestDestinations("product_list")

    data object ProductDetails : NavTestDestinations("product_details/{productId}") {
        fun productDetailsRoute(productId: String) = "product_details/$productId"
    }

    data object Cart : NavTestDestinations("cart")

    data object Checkout : NavTestDestinations("checkout")
}

@Composable
fun rememberNavTestNavigationActions(
    navController: NavController = rememberNavController(),
    context: Context = LocalContext.current
) = remember(navController, context) {
    NavTestNavigationActions(navController)
}

class NavTestNavigationActions(private val navController: NavController) {
    fun navigateToHome() {
        navController.navigate(NavTestDestinations.Home.route) {
            popUpTo(NavTestDestinations.Home.route)
            launchSingleTop = true
        }
    }
    fun navigateToProductList() {
        navController.navigate(NavTestDestinations.ProductList.route)
    }
    fun navigateToProductDetails(productId: String) {
        navController.navigate(NavTestDestinations.ProductDetails.productDetailsRoute(productId))
    }
    fun navigateToCart() {
        navController.navigate(NavTestDestinations.Cart.route)
    }
    fun navigateToCheckout() {
        navController.navigate(NavTestDestinations.Checkout.route)
    }
    fun navigateBack() {
        navController.popBackStack()
    }
}