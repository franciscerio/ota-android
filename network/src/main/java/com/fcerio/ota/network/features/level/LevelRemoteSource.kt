package com.fcerio.ota.network.features.level

import com.fcerio.ota.domain.Level

interface LevelRemoteSource {
    suspend fun getLevels(): List<Level>
}