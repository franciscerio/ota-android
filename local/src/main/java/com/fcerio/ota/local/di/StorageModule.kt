package com.fcerio.ota.local.di

import android.content.Context
import android.content.SharedPreferences
import com.fcerio.ota.local.features.level.LevelLocalSource
import com.fcerio.ota.local.features.level.LevelLocalSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext application: Context): SharedPreferences {
        val filename = application.packageName + "_preferences"
        return  application.getSharedPreferences(filename, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesLevelLocalSource(
        sharedPreferences: SharedPreferences
    ): LevelLocalSource {
        return LevelLocalSourceImpl(
            sharedPreferences
        )
    }
}
