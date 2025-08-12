package com.example.comics.presentation.di

import com.example.comics.presentation.coroutines.CoroutineDispatcherProvider
import com.example.comics.presentation.coroutines.CoroutineDispatcherProviderImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val presentationModule = module {
    singleOf(::CoroutineDispatcherProviderImpl) { bind<CoroutineDispatcherProvider>() }
}