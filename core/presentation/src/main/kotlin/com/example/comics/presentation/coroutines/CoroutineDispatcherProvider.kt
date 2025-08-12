package com.example.comics.presentation.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val viewModel: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
