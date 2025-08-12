package com.example.comics.home.presentation.home.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.comics.home.domain.usecase.GetComicsUseCase

internal class ComicsPagingSource(
    private val getComicsUseCase: GetComicsUseCase
) : PagingSource<Int, ComicsPagingItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ComicsPagingItem> {
        val page = params.key ?: 1
        return getComicsUseCase(
            page = page,
            itemsPerPage = ITEMS_PER_PAGE
        ).fold(
            onSuccess = {
                val items = mutableListOf<ComicsPagingItem>()
                if (page == 1) {
                    items.add(ComicsPagingItem.Header)
                }
                it.items.forEach { comic ->
                    items.add(ComicsPagingItem.Item(comic))
                    items.add(ComicsPagingItem.Divider)
                }

                LoadResult.Page(
                    data = items,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (it.items.isEmpty()) null else page + 1
                )
            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }

    override fun getRefreshKey(state: PagingState<Int, ComicsPagingItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val ITEMS_PER_PAGE = 50
    }
}