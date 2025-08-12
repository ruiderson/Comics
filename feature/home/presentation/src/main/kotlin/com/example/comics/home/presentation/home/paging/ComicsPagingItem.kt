package com.example.comics.home.presentation.home.paging

import com.example.comics.domain.models.Comic

internal sealed interface ComicsPagingItem {
    data class Item(val comic: Comic) : ComicsPagingItem
    object Header : ComicsPagingItem
    object Divider : ComicsPagingItem
}
