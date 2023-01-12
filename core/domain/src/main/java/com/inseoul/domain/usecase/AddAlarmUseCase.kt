package com.inseoul.domain.usecase

import com.inseoul.domain.qualifiers.IoDispatcher
import com.inseoul.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddAlarmUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

}