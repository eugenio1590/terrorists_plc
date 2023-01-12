package com.terrorists.domain.usecase

internal fun interface UseCase<R, P> {
    suspend fun invoke(params: R, callback: P)
}