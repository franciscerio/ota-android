package com.fcerio.ota.network.models

import com.fcerio.ota.domain.File
import com.fcerio.ota.domain.FileDetails

data class FileDTO(
    val url: String,
    val details: FileDetailsDTO,
    val fileName: String,
    val contentType: String
)

data class FileDetailsDTO(
    val size: Long
)

fun FileDTO.toDomain(): File {
    return with(this) {
        File(
            url = url,
            details = details.toDomain(),
            fileName = fileName,
            contentType = contentType
        )
    }
}

fun FileDetailsDTO.toDomain(): FileDetails {
    return with(this) {
        FileDetails(
            size = size
        )
    }
}