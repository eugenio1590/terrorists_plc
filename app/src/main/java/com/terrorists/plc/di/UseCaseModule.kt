package com.terrorists.plc.di

import com.terrorists.domain.repository.TerroristsRepository
import com.terrorists.domain.usecase.LoadTerrorists
import com.terrorists.domain.usecase.SearchTerrorists
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideLoadTerrorists(terroristsRepository: TerroristsRepository): LoadTerrorists {
        return LoadTerrorists(terroristsRepository)
    }

    @Provides
    fun provideSearchTerrorists(terroristsRepository: TerroristsRepository): SearchTerrorists {
        return SearchTerrorists(terroristsRepository)
    }
}