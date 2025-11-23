package com.example.testapplication.repository

import com.example.testapplication.ApiInterface
import com.example.testapplication.data.users.models.response.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: ApiInterface
) {
    suspend fun getProducts()= api.getProducts()
}