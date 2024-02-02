package com.serranoie.wishin.di

import android.app.Application
import com.serranoie.wishin.data.manager.LocalUserManagerImpl
import com.serranoie.wishin.domain.manager.LocalUserManager
import com.serranoie.wishin.domain.usecases.appentry.AppEntryUseCase
import com.serranoie.wishin.domain.usecases.appentry.ReadAppEntry
import com.serranoie.wishin.domain.usecases.appentry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application,
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserManager: LocalUserManager) = AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager),
    )
}
