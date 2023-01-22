package com.inseoul.domain.usecase

import com.inseoul.domain.entity.AuthInfoData
import com.inseoul.domain.qualifiers.IoDispatcher
import com.inseoul.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMemberInfoUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun invoke(firebase_token: String): Flow<AuthInfoData> {
        return repository.getMemberInfo(firebase_token)
            .flowOn(dispatcher)
    }
}