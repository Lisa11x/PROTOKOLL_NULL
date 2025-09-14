package com.protokollnull.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// Datenmodell für Mindat-Orte
data class MindatLocation(
    val id: Int,
    val name: String,
    val latitude: Double?,
    val longitude: Double?
)

interface MindatService {
    @GET("localities/")
    suspend fun searchLocalities(
        @Header("Authorization") apiKey: String,
        @Query("q") query: String,
        @Query("format") format: String = "json"
    ): MindatResponse
}

data class MindatResponse(
    val results: List<MindatLocation>
)
