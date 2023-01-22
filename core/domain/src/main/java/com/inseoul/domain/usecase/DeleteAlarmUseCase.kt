package com.inseoul.domain.usecase

import com.inseoul.domain.repository.Repository
import javax.inject.Inject

class DeleteAlarmUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun invoke(alarm_id: Int?) {
        return repository.deleteAlarm(alarm_id)
    }
}