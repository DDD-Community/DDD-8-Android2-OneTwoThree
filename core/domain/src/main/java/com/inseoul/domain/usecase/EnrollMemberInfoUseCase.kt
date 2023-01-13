package com.inseoul.domain.usecase

import com.inseoul.domain.entity.MemberId
import com.inseoul.domain.qualifiers.IoDispatcher
import com.inseoul.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class EnrollMemberInfoUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun invoke(
        nickname: String,
        firebaseToken: String
    ): Flow<MemberId> {
        return repository.enrollMemberInfo(nickname, firebaseToken)
            .flowOn(dispatcher)
    }
}