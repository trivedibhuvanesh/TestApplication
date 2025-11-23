package com.example.testapplication.repository

import com.example.testapplication.ApiInterface
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: ApiInterface
) {
    suspend fun getProducts()= api.getProducts()
}