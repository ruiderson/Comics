package com.example.comics.home.presentation.di

import com.example.comics.home.presentation.home.interaction.HomeViewModel
import com.example.comics.home.presentation.registration.interaction.RegistrationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homePresentationModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::RegistrationViewModel)
}
