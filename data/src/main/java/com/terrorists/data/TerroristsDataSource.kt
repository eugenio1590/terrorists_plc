package com.terrorists.data

import com.terrorists.data.mapper.TerroristMapper
import com.terrorists.data.service.TerroristsService
import com.terrorists.domain.repository.TerroristsRepository
import com.terrorists.model.Terrorist

class TerroristsDataSource(
    private val terroristsService: TerroristsService,
    private val terroristMapper: TerroristMapper = TerroristMapper()
) : TerroristsRepository {

    private var terrorists = mutableListOf<Terrorist>()

    override suspend fun get(keyword: String?): List<Terrorist> {
        if (keyword != null) {
            return terrorists.filter { it.name.contains(keyword, ignoreCase = true) }
        } else {
            val response = terroristsService.getTerrorists()
            if (response.isSuccessful) {
                val list = response.body()?.terrorists ?: emptyList()
                terrorists = list.map { terroristMapper.toModel(it) }.toMutableList()
            }
        }
        return terrorists
    }
}