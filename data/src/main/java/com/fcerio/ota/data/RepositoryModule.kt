package com.fcerio.ota.data

import com.fcerio.ota.data.features.level.LevelRepository
import com.fcerio.ota.data.features.level.LevelRepositoryImpl
import com.fcerio.ota.local.features.level.LevelLocalSource
import com.fcerio.ota.network.features.level.LevelRemoteSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLevelRepository(
        repository: LevelRepositoryImpl
    ): LevelRepository
}
