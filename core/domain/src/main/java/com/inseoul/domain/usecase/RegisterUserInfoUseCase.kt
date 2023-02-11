package com.inseoul.domain.usecase

import com.inseoul.domain.entity.AuthInfoData
import com.inseoul.domain.params.RegisterUserInfoUseCaseParams
import com.inseoul.domain.repository.UserInfoRepository
import com.inseoul.domain.usecase.base.ResultUseCase
import javax.inject.Inject

class RegisterUserInfoUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) : ResultUseCase<RegisterUserInfoUseCaseParams, AuthInfoData>() {
    override suspend fun execute(params: RegisterUserInfoUseCaseParams): AuthInfoData {
        return userInfoRepository.registerUserInfo(
            nickname = params.nickname,
            firebaseToken = params.firebaseToken
        )
    }
}
