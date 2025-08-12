package com.example.comics.home.presentation.home.interaction

import androidx.paging.compose.LazyPagingItems
import com.example.comics.home.presentation.home.paging.ComicsPagingItem

internal sealed interface HomeState {
    object Loading : HomeState
    object Error : HomeState
    data class Success(val items: LazyPagingItems<ComicsPagingItem>) : HomeState
}
