package com.example.comics.home.presentation.home.interaction

import com.example.comics.domain.models.Comic

internal sealed interface HomeEffect {
    object RefreshPagination : HomeEffect
    data class NavigateToDetails(val comic: Comic) : HomeEffect
}
