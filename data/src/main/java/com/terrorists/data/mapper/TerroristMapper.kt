package com.terrorists.data.mapper

import com.terrorists.data.dto.TerroristDto
import com.terrorists.model.Terrorist

class TerroristMapper {
    fun toModel(dto: TerroristDto): Terrorist {
        return Terrorist(
            firstName = dto.firstName ?: "",
            lastName = dto.lastName ?: "",
            dateOfBirth = dto.dateOfBirthList?.firstOrNull()?.date ?: "",
            placeOfBirth = dto.placeOfBirthList?.firstOrNull()?.place ?: "",
        )
    }
}