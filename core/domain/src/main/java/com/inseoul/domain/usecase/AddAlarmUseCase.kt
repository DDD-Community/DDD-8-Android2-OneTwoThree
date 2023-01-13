package com.inseoul.domain.usecase

import com.inseoul.domain.repository.Repository
import javax.inject.Inject

class AddAlarmUseCase @Inject constructor(
    private val repository: Repository,
) {
    suspend fun invoke(
        onetwothreeMemberId: Int,
                       dayOfWeeks: List<String>,
                       excludeHoliday: Boolean,
                       startTime: String,
                       endTime: String,
                       count: Int
    ) {
        return repository.addAlarm(
            onetwothreeMemberId, dayOfWeeks, excludeHoliday, startTime, endTime, count
        )
    }
}