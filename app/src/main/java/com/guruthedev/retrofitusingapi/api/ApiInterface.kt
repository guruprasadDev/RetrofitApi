package com.guruthedev.retrofitusingapi.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/users")
    suspend fun getUserDetails(): Response<ClassModel>
}