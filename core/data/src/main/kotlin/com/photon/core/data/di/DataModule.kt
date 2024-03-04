package com.photon.core.data.di

import com.photon.core.data.FindMyIpRepository
import com.photon.core.data.FindMyIpRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    internal abstract fun bindsFindMyIpRepository(
        repository: FindMyIpRepositoryImpl
    ) : FindMyIpRepository
}