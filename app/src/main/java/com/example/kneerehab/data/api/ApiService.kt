
package com.example.kneerehab.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("lang") language: String = "pt",
        @Query("max") max: Int = 10,
        @Query("apikey") apiKey: String
    ): NewsResponse
}
