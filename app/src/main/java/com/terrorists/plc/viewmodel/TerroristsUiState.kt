package com.terrorists.plc.viewmodel

import com.terrorists.model.Terrorist

sealed interface TerroristsUiState {
    object Initial : TerroristsUiState
    object Loading : TerroristsUiState
    data class Success(val terrorists: List<Terrorist>) : TerroristsUiState
}