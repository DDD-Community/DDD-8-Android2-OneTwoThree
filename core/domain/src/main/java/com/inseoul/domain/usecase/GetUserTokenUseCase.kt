package com.inseoul.domain.usecase

import com.inseoul.domain.repository.UserInfoRepository
import javax.inject.Inject

class GetUserTokenUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {
    operator fun invoke(): String = userInfoRepository.userToken
}
