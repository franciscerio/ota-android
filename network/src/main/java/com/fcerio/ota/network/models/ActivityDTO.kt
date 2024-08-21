package com.fcerio.ota.network.models

import com.fcerio.ota.domain.Activity

data class ActivityDTO(
    val id: String,
    val challengeId: String,
    val type: String,
    val title: String,
    val titleB: String?,
    val description: String,
    val descriptionB: String?,
    val state: String,
    val icon: IconDTO,
    val lockedIcon: IconDTO
)

fun ActivityDTO.toDomain(): Activity {
    return with(this) {
        Activity(
            id = id,
            challengeId = challengeId,
            type = type,
            title = title,
            titleB = titleB,
            description = description,
            descriptionB = descriptionB,
            state = state,
            icon = icon.toDomain(),
            lockedIcon = lockedIcon.toDomain()
        )
    }
}