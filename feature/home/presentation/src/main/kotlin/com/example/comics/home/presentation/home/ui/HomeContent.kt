package com.example.comics.home.presentation.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.example.comics.domain.models.Comic
import com.example.comics.home.presentation.home.interaction.HomeEvent
import com.example.comics.home.presentation.home.interaction.HomeState
import com.example.comics.home.presentation.home.paging.ComicsPagingItem
import com.example.comics.presentation.components.RemoteImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeContent(
    state: HomeState.Success,
    onEvent: (HomeEvent) -> Unit
) {
    val pullToRefreshState = rememberPullToRefreshState()
    val isRefreshing = state.items.loadState.refresh is LoadState.Loading

    PullToRefreshBox(
        state = pullToRefreshState,
        isRefreshing = isRefreshing,
        onRefresh = { onEvent(HomeEvent.OnRefresh()) },
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing,
                state = pullToRefreshState
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                count = state.items.itemCount,
                key = { it }
            ) { position ->
                state.items[position]?.let {
                    when (it) {
                        is ComicsPagingItem.Item -> ComicItem(
                            comic = it.comic,
                            onItemSelected = {
                                onEvent(HomeEvent.OnItemSelected(it))
                            }
                        )

                        is ComicsPagingItem.Header -> Box(Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .background(Color.White))

                        is ComicsPagingItem.Divider -> HorizontalDivider()
                    }
                }
            }

            state.items.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { ComicPlaceholder() }
                    }
                    loadState.append is LoadState.Loading -> {
                        item { ComicPlaceholder() }
                    }
                    loadState.refresh is LoadState.Error -> {
                        item { ErrorPlaceholder() }
                    }
                    loadState.append is LoadState.Error -> {
                        item { ErrorPlaceholder() }
                    }
                }
            }
        }
    }
}

@Composable
private fun ComicItem(
    comic: Comic,
    onItemSelected: (Comic) -> Unit,
    modifier: Modifier = Modifier
) = Row(
    modifier = modifier
        .clickable {
            onItemSelected(comic)
        }
        .padding(16.dp)
        .height(120.dp)
        .fillMaxWidth()
        .background(Color.White)

) {

    Box(Modifier
        .fillMaxHeight()
        .aspectRatio(0.7f)
        .clip(RoundedCornerShape(12.dp))
    ) {
        comic.image?.let {
            RemoteImage(
                url = it,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        } ?: Box(Modifier.fillMaxSize().background(Color.LightGray))
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = comic.title,
            textAlign = TextAlign.Center,
            maxLines = 2,
            fontSize = 18.sp
        )
        Text(
            text = comic.description ?: "",
            textAlign = TextAlign.Center,
            maxLines = 2,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun ComicPlaceholder(
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .height(20.dp)
        .background(Color.White)
) {
    CircularProgressIndicator(
        modifier = Modifier
            .size(10.dp)
            .align(Alignment.Center)
    )
}

@Composable
private fun ErrorPlaceholder(
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .height(20.dp)
        .background(Color.Red)
) {
    Text(
        text = "Something went wrong",
        color = Color.White,
        fontSize = 16.sp
    )
}