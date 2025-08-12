package com.example.comics.home.presentation.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.comics.domain.models.Comic
import com.example.comics.home.presentation.home.interaction.HomeEffect
import com.example.comics.home.presentation.home.interaction.HomeEvent
import com.example.comics.home.presentation.home.interaction.HomeViewModel
import com.example.comics.presentation.interaction.onEffectChanged
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    onNavigateToDetails: (Comic) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val pagination = viewModel.pagination.collectAsLazyPagingItems()

    viewModel.effect.onEffectChanged {
        when (it) {
            is HomeEffect.NavigateToDetails -> onNavigateToDetails(it.comic)
            is HomeEffect.RefreshPagination -> {
                pagination.refresh()
            }
        }
    }

    when (pagination.loadState.refresh) {
        is LoadState.Loading -> SideEffect {
            viewModel.onEvent(HomeEvent.OnPagingStateChanged(
                items = pagination,
                isPagingLoading = true
            ))
        }

        is LoadState.Error -> SideEffect {
            viewModel.onEvent(HomeEvent.OnPagingStateChanged(
                items = pagination,
                isError = true
            ))
        }

        else -> SideEffect {
            viewModel.onEvent(HomeEvent.OnPagingStateChanged(pagination))
        }
    }

    HomeScaffold(
        state = state.value,
        onEvent = viewModel::onEvent
    )
}
