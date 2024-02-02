package com.serranoie.wishin.domain.usecases

import com.serranoie.wishin.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}