package com.example.comics.di

import androidx.compose.runtime.Composable
import com.example.comics.data.di.dataModule
import com.example.comics.home.data.di.homeDataModule
import com.example.comics.home.domain.di.homeDomainModule
import com.example.comics.home.presentation.di.homePresentationModule
import com.example.comics.presentation.di.presentationModule
import org.koin.dsl.KoinAppDeclaration

@Composable
internal fun setupKoinApplication(): KoinAppDeclaration = {
    modules(
        dataModule,
        presentationModule,
        homeDomainModule,
        homeDataModule,
        homePresentationModule
    )
}