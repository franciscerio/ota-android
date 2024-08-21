package com.fcerio.ota.network.features.level

import android.content.Context
import com.fcerio.ota.domain.Level
import com.fcerio.ota.network.features.level.response.GetLevelResponse
import com.fcerio.ota.network.models.toDomain
import com.google.gson.Gson
import javax.inject.Inject


internal class LevelRemoteSourceImpl @Inject constructor(
    private val context: Context,
    private val gson: Gson
) : LevelRemoteSource {

    override suspend fun getLevels(): List<Level> {
        val json = readJsonFromAssets(context, "response_1709543815894.json")
        val response: GetLevelResponse = gson.fromJson(json, GetLevelResponse::class.java)

        return response
            .levels
            .map {
                it.toDomain()
            }
    }

    private fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}
