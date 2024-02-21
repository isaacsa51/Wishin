package com.serranoie.wishin.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.serranoie.wishin.data.persistance.db.WishinDB
import com.serranoie.wishin.data.persistance.db.dao.ItemDao
import com.serranoie.wishin.data.persistance.db.prefs.manager.LocalUserManagerImpl
import com.serranoie.wishin.domain.manager.LocalUserManager
import com.serranoie.wishin.domain.usecases.appentry.AppEntryUseCase
import com.serranoie.wishin.domain.usecases.appentry.ReadAppEntry
import com.serranoie.wishin.domain.usecases.appentry.SaveAppEntry
import com.serranoie.wishin.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideItemDao(database: WishinDB): ItemDao = database.itemDao

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): WishinDB = Room.databaseBuilder(
        context,
        WishinDB::class.java,
        Constants.DB_NAME,
    ).build()
}
