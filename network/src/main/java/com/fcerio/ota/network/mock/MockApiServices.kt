package com.fcerio.ota.network.mock

import com.fcerio.ota.network.features.level.response.GetLevelResponse
import com.fcerio.ota.network.models.LevelDTO
import retrofit2.http.*

interface MockApiServices {

    @Headers("mock:true")
    @GET("response_1709543815894")
    suspend fun getResponse(): GetLevelResponse
}
