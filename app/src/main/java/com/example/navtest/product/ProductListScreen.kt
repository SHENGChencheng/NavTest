package com.example.navtest.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navtest.utils.NavTestNavigationActions

@Composable
fun ProductListScreen(navigationActions: NavTestNavigationActions) {
    val productList = listOf("1", "2", "3")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
    ) {

        Text(text = "Product List")
        productList.forEach { productId ->
            Button(onClick = { navigationActions.navigateToProductDetails(productId) }) {
                Text(text = "Product $productId Details")
            }
        }
        Button(onClick = { navigationActions.navigateToCart() }) {
            Text(text = "Go to Cart")
        }
    }
}