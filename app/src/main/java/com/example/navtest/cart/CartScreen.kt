package com.example.navtest.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navtest.utils.NavTestNavigationActions

@Composable
fun CartScreen(
    navigationActions: NavTestNavigationActions,
    cartViewModel: CartViewModel
) {
    val productSet = cartViewModel.productSet

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Cart")
        Column {
            productSet.forEach { product ->
                CartItem(productId = product.productId, productQuantity = product.quantity)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navigationActions.navigateToCheckout() }) {
            Text(text = "Proceed to Checkout")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                navigationActions.navigateBack()
            }
        ) {
            Text(text = "Back")
        }
    }
}

@Composable
fun CartItem(productId: String, productQuantity: Int = 1) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Product: $productId")
        Text(text = "Quantity: x$productQuantity")
    }
}