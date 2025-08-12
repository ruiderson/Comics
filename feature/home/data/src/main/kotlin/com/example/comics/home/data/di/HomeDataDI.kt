package com.example.comics.home.data.di

import com.example.comics.home.data.datasource.ComicsRemoteDataSource
import com.example.comics.home.data.datasource.ComicsRemoteDataSourceImpl
import com.example.comics.home.data.repository.HomeRepositoryImpl
import com.example.comics.home.domain.repository.HomeRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeDataModule = module {
    factoryOf(::HomeRepositoryImpl) {
        bind<HomeRepository>()
    }
    factoryOf(::ComicsRemoteDataSourceImpl) {
        bind<ComicsRemoteDataSource>()
    }
}
