package com.fcerio.ota.network.features.level.response

import com.fcerio.ota.network.models.LevelDTO

data class GetLevelResponse(val levels: List<LevelDTO>)