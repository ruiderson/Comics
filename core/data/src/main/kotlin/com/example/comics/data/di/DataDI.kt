package com.example.comics.data.di

import com.example.comics.data.base.HttpClientProvider
import com.example.comics.data.base.HttpClientProviderImpl
import com.example.comics.data.themoviedb.TheMovieDbApi
import com.example.comics.data.themoviedb.TheMovieDbApiImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::HttpClientProviderImpl) {
        bind<HttpClientProvider>()
    }
    factoryOf(::TheMovieDbApiImpl) {
        bind<TheMovieDbApi>()
    }
}
