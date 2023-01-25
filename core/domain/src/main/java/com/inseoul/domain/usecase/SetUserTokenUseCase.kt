package com.inseoul.domain.usecase

import com.inseoul.domain.repository.UserInfoRepository
import javax.inject.Inject

class SetUserTokenUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {
    operator fun invoke(token: String) {
        userInfoRepository.userToken = token
    }
}
