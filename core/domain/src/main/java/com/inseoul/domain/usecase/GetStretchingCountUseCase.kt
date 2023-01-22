package com.inseoul.domain.usecase

import com.inseoul.domain.entity.StretchingAuthCount
import com.inseoul.domain.qualifiers.IoDispatcher
import com.inseoul.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetStretchingCountUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun invoke(
        onetwothree_member_id: Int,
        stretchingType: String
    ): Flow<StretchingAuthCount> {
        return repository.getStretchingCount(
            onetwothree_member_id, stretchingType
        ).flowOn(dispatcher)
    }
}