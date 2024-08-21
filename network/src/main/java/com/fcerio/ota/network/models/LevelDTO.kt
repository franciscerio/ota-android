package com.fcerio.ota.network.models

import com.fcerio.ota.domain.Level

data class LevelDTO(
    val level: Int,
    val title: String,
    val description: String,
    val state: String,
    val activities: List<ActivityDTO> = emptyList()
)

fun LevelDTO.toDomain(): Level {
    return with(this) {
        Level(
            level = level,
            title = title,
            description = description,
            state = state,
            activities = activities.map { it.toDomain() }
        )
    }
}