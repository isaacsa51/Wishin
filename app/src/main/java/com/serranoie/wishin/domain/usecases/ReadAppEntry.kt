package com.serranoie.wishin.domain.usecases

import com.serranoie.wishin.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}