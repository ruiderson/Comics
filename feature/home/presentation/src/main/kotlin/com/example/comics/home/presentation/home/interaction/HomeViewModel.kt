package com.example.comics.home.presentation.home.interaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.comics.domain.models.Comic
import com.example.comics.home.domain.usecase.GetComicsUseCase
import com.example.comics.home.presentation.home.paging.ComicsPagingItem
import com.example.comics.home.presentation.home.paging.ComicsPagingSource
import com.example.comics.presentation.coroutines.CoroutineDispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getComicsUseCase: GetComicsUseCase,
    private val dispatchers: CoroutineDispatcherProvider,
): ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    internal val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<HomeEffect>()
    internal val effect = _effect.asSharedFlow()

    internal val pagination: Flow<PagingData<ComicsPagingItem>> = Pager(
        config = PagingConfig(
            pageSize = ComicsPagingSource.ITEMS_PER_PAGE,
        ),
        pagingSourceFactory = { ComicsPagingSource(getComicsUseCase) }
    ).flow.cachedIn(viewModelScope)

    internal fun onEvent(event: HomeEvent) = when (event) {
        is HomeEvent.OnRefresh -> onRefresh(event)
        is HomeEvent.OnPagingStateChanged -> onPagingStateChanged(event)
        is HomeEvent.OnItemSelected -> navigateToDetails(event.item)
    }

    private fun onRefresh(event: HomeEvent.OnRefresh) = viewModelScope.launch(dispatchers.viewModel) {
        if (event.showLoadingScreen) {
            _state.value = HomeState.Loading
        }
        _effect.emit(HomeEffect.RefreshPagination)
    }

    private fun onPagingStateChanged(event: HomeEvent.OnPagingStateChanged) {
        when {
            event.isError -> {
                _state.value = HomeState.Error
            }

            else -> {
                _state.value = HomeState.Success(event.items)
            }
        }
    }

    private fun navigateToDetails(comic: Comic) = viewModelScope.launch(dispatchers.viewModel) {
        _effect.emit(HomeEffect.NavigateToDetails(comic))
    }
}
