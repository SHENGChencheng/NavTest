package com.example.navtest.home

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
fun HomeScreen(navigationActions: NavTestNavigationActions) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Welcome to the Store")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navigationActions.navigateToProductList() }) {
            Text(text = "View Products")
        }
    }
}