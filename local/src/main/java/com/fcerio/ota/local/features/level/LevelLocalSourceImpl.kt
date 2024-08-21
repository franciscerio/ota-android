package com.fcerio.ota.local.features.level

import android.content.SharedPreferences
import com.fcerio.ota.domain.Level
import timber.log.Timber
import javax.inject.Inject

internal class LevelLocalSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : LevelLocalSource {

    override suspend fun getLevels(): List<Level> {
        return emptyList()
    }

    override suspend fun saveLevels(items: List<Level>) {
        Timber.d("Save levels $items")
    }
}
