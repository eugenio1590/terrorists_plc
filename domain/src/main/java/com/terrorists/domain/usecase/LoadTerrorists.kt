package com.terrorists.domain.usecase

import com.terrorists.domain.repository.TerroristsRepository
import com.terrorists.model.Terrorist

class LoadTerrorists(
    private val terroristsRepository: TerroristsRepository
) : UseCase<LoadTerrorists.Request, LoadTerrorists.Callback> {

    override suspend fun invoke(params: Request, callback: Callback) {
        val terrorists = terroristsRepository.get()
        callback.load(terrorists)
    }

    class Request

    interface Callback {
        fun load(terrorists: List<Terrorist>)
    }
}