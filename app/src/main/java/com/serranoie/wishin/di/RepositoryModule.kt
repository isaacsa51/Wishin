package com.serranoie.wishin.di

import com.serranoie.wishin.data.repositories.ItemRepositoryImpl
import com.serranoie.wishin.domain.repositories.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: ItemRepositoryImpl): ItemRepository
}
