package com.fcerio.ota.network.models

import com.fcerio.ota.domain.Icon

data class IconDTO(
    val file: FileDTO,
    val title: String,
    val description: String?
)

fun IconDTO.toDomain(): Icon {
    return with(this) {
        Icon(
            file = file.toDomain(),
            title = title,
            description = description
        )
    }
}