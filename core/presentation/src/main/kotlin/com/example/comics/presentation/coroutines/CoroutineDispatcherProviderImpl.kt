package com.example.comics.presentation.coroutines

import kotlinx.coroutines.Dispatchers

internal class CoroutineDispatcherProviderImpl : CoroutineDispatcherProvider {
    override val viewModel = Dispatchers.Main
    override val io = Dispatchers.IO
    override val default = Dispatchers.Default
    override val main = Dispatchers.Main
    override val unconfined = Dispatchers.Unconfined
}
