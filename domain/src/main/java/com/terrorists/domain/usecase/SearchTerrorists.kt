package com.terrorists.domain.usecase

import com.terrorists.domain.repository.TerroristsRepository
import com.terrorists.model.Terrorist

class SearchTerrorists(
    private val terroristsRepository: TerroristsRepository
) : UseCase<SearchTerrorists.Request, SearchTerrorists.Callback> {

    override suspend fun invoke(params: Request, callback: Callback) {
        val terrorists = terroristsRepository.get(params.keyword)
        callback.load(terrorists)
    }

    data class Request(val keyword: String)

    interface Callback {
        fun load(terrorists: List<Terrorist>)
    }
}