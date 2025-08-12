package com.example.comics.home.presentation.home.interaction

import androidx.paging.compose.LazyPagingItems
import com.example.comics.domain.models.Comic
import com.example.comics.home.presentation.home.paging.ComicsPagingItem

internal sealed interface HomeEvent {
    data class OnRefresh(
        val showLoadingScreen: Boolean = false
    ) : HomeEvent

    data class OnPagingStateChanged(
        val items: LazyPagingItems<ComicsPagingItem>,
        val isPagingLoading: Boolean = false,
        val isError: Boolean = false
    ): HomeEvent

    data class OnItemSelected(val item: Comic): HomeEvent
}
