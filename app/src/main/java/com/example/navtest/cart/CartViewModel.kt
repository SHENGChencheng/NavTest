package com.example.navtest.cart

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.navtest.model.Product

class CartViewModel : ViewModel(), ICartViewModel {
    private val _productSet = mutableStateOf(emptySet<Product>())
    val productSet: Set<Product> get() = _productSet.value


    override fun addProduct(productId: String, quantity: Int) {
        val existingProduct = productSet.find { it.productId == productId }
        if (existingProduct != null) {
            val newQuantity = existingProduct.quantity + quantity
            val updatedProduct = existingProduct.copy(quantity = newQuantity)
            val updatedProductSet = productSet - existingProduct + updatedProduct
            _productSet.value = updatedProductSet
        } else {
            val newProduct = Product(productId, quantity)
            _productSet.value = productSet + newProduct
        }
    }

    override fun clearCart() {
        _productSet.value = emptySet()
    }
}