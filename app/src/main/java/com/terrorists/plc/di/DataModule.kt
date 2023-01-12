package com.terrorists.plc.di

import com.terrorists.data.TerroristsDataSource
import com.terrorists.data.service.TerroristsService
import com.terrorists.domain.repository.TerroristsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun provideTerroristsRepository(terroristsService: TerroristsService): TerroristsRepository {
        return TerroristsDataSource(terroristsService)
    }
}