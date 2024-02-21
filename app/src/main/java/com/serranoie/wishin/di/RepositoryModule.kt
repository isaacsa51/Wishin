package com.serranoie.wishin.di

import com.serranoie.wishin.data.repositories.ItemRepositoryImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    abstract fun bindRepository(repositoryImpl: ItemRepositoryImpl)
}
