package com.inseoul.domain.usecase

import com.inseoul.domain.repository.Repository
import javax.inject.Inject

class ChangeNicknameUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun invoke(
        onetwothreeMemberId: Int, nickname: String
    ) {
        return repository.changeNickname(
            onetwothreeMemberId, nickname
        )
    }
}