package com.inseoul.domain.usecase

import com.inseoul.domain.entity.StartStretchingEntityResponse
import com.inseoul.domain.qualifiers.IoDispatcher
import com.inseoul.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class StartStretchingUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun invoke(): Flow<StartStretchingEntityResponse> {
        return repository.startStretching()
            .flowOn(dispatcher)
    }
}