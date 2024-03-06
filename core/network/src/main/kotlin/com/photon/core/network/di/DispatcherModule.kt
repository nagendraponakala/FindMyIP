package com.photon.core.network.di

import com.photon.core.network.AppDispatchers
import com.photon.core.network.Dispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @Dispatchers(AppDispatchers.IO)
    fun providesIODispatcher():CoroutineDispatcher = kotlinx.coroutines.Dispatchers.IO
}