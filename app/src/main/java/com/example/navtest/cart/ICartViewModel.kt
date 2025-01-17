package com.example.navtest.cart

interface ICartViewModel {

    fun addProduct(productId: String, quantity: Int)

    fun clearCart()
}