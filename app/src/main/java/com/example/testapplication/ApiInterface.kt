package com.example.testapplication

import com.example.testapplication.data.products.ProductsResponse
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    suspend fun getProducts(): ProductsResponse?
}