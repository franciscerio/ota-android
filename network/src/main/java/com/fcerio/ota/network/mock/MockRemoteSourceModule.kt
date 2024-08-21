package com.fcerio.ota.network.mock

import android.content.Context
import com.fcerio.ota.network.features.level.LevelRemoteSource
import com.fcerio.ota.network.features.level.LevelRemoteSourceImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MockRemoteSourceModule {

    @Provides
    @Singleton
    fun providesMockApiServices(retrofit: Retrofit): MockApiServices =
        retrofit.create(MockApiServices::class.java)

    @Provides
    @Singleton
    fun providesLevelRemoteSource(
        @ApplicationContext context: Context,
        gson: Gson
    ): LevelRemoteSource = LevelRemoteSourceImpl(context, gson)
}
