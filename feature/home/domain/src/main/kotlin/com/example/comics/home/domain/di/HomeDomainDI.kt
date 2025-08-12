package com.example.comics.home.domain.di

import com.example.comics.home.domain.usecase.GetComicsUseCase
import com.example.comics.home.domain.usecase.GetComicsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeDomainModule = module {
    factoryOf(::GetComicsUseCaseImpl) {
        bind<GetComicsUseCase>()
    }
}
