package com.example.comics.presentation.interaction

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <T> SharedFlow<T>.onEffectChanged(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    callback: (T) -> Unit
) = LaunchedEffect(this, lifecycleOwner) {
    lifecycleOwner.lifecycle.repeatOnLifecycle(onActiveState) {
        collectLatest { callback.invoke(it) }
    }
}