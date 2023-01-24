package com.inseoul.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class ResultUseCase<T, R>(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    abstract suspend fun execute(params: T): R

    suspend operator fun invoke(params: T): Result<R> {
        return try {
            withContext(dispatcher) {
                execute(params).let {
                    Result.Success(data = it)
                }
            }
        } catch (e: Exception) {
            Result.Error(exception = e)
        }
    }
}
