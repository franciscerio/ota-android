package com.fcerio.ota.data.features.level

import com.fcerio.ota.domain.Level
import kotlinx.coroutines.flow.Flow

interface LevelRepository {
    suspend fun getLevels(): Flow<List<Level>>
}