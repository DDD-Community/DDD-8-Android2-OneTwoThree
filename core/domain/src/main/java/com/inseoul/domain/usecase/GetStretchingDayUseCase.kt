package com.inseoul.domain.usecase

import com.inseoul.domain.entity.GetStretchingDayEntityResponse
import com.inseoul.domain.qualifiers.IoDispatcher
import com.inseoul.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetStretchingDayUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun invoke(
        onetwothreeMemberId: Int,
        year: Int?,
        month: Int?,
        day: Int?
    ): Flow<GetStretchingDayEntityResponse> {
        return repository.getStretchingDay(
            onetwothreeMemberId, year, month, day
        ).flowOn(dispatcher)
    }
}