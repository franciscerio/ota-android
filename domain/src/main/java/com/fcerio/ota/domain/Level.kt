package com.fcerio.ota.domain

data class Level(
    val level: Int,
    val title: String,
    val description: String,
    val state: String,
    val activities: List<Activity> = emptyList()
)