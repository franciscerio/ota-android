package com.fcerio.ota.local.features.level

import com.fcerio.ota.domain.Level

interface LevelLocalSource {
    suspend fun getLevels(): List<Level>
    suspend fun saveLevels(items: List<Level>)
}