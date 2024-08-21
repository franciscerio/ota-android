package com.fcerio.ota.data.features.level

import com.fcerio.ota.domain.Level
import com.fcerio.ota.local.features.level.LevelLocalSource
import com.fcerio.ota.network.features.level.LevelRemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LevelRepositoryImpl @Inject constructor(
    private val remote: LevelRemoteSource,
    private val local: LevelLocalSource
) : LevelRepository {

    override suspend fun getLevels(): Flow<List<Level>> {
        return flow {
            // Add more logic
            val levels = remote.getLevels()
            local.saveLevels(levels)
            emit(levels)
        }
    }
}
