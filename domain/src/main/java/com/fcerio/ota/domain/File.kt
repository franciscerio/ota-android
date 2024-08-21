package com.fcerio.ota.domain

data class File(
    val url: String,
    val details: FileDetails,
    val fileName: String,
    val contentType: String
)

data class FileDetails(
    val size: Long
)