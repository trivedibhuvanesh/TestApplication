package com.example.testapplication

import com.example.testapplication.data.products.ProductsResponse
import com.example.testapplication.data.users.models.response.User
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    suspend fun getProducts(): ProductsResponse?
}