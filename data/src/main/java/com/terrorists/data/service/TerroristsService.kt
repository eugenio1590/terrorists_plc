package com.terrorists.data.service

import com.terrorists.data.dto.TerroristListDto
import retrofit2.Response
import retrofit2.http.GET

interface TerroristsService {
    @GET("ofac/downloads/consolidated/consolidated.xml")
    suspend fun getTerrorists(): Response<TerroristListDto>
}