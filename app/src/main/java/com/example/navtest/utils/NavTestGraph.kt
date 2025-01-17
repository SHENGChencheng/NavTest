package com.example.navtest.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navtest.cart.CartScreen
import com.example.navtest.cart.CartViewModel
import com.example.navtest.checkout.CheckoutScreen
import com.example.navtest.home.HomeScreen
import com.example.navtest.product.ProductDetailsScreen
import com.example.navtest.product.ProductListScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    val navigationActions = rememberNavTestNavigationActions(navController)
    val cartViewModel = CartViewModel()

    NavHost(navController = navController, startDestination = NavTestDestinations.Home.route) {
        composable(NavTestDestinations.Home.route) {
            HomeScreen(navigationActions)
        }
        composable(NavTestDestinations.ProductList.route) {
            ProductListScreen(navigationActions)
        }
        composable(
            NavTestDestinations.ProductDetails.route,
            arguments = listOf(
                navArgument("productId") { type = NavType.StringType },
            )
        ) { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getString("productId") ?: "Unknown"
            ProductDetailsScreen(
                navigationActions = navigationActions,
                productId = productId,
                cartViewModel
            )
        }
        composable(NavTestDestinations.Cart.route,) {
            CartScreen(navigationActions, cartViewModel)
        }
        composable(NavTestDestinations.Checkout.route) {
            CheckoutScreen(navigationActions)
        }
    }
}