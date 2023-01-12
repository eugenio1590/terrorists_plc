package com.terrorists.domain.repository

import com.terrorists.model.Terrorist

interface TerroristsRepository {
    suspend fun get(keyword: String? = null): List<Terrorist>
}