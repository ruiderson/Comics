package com.example.comics.home.presentation.di

import com.example.comics.home.presentation.home.interaction.HomeViewModel
import org.koin.dsl.module

val homePresentationModule = module {
    factory {
        HomeViewModel(
            getComicsUseCase = get(),
            dispatchers = get()
        )
    }
}
