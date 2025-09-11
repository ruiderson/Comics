package com.example.comics.presentation.interaction

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.properties.ReadOnlyProperty

abstract class ComposeViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    protected fun <T> savableStateFlowOf(
        initial: T,
        key: String? = null
    ): ReadOnlyProperty<Any, SavableStateFlow<T>> = savedStateHandle.savableStateFlowOf(initial, key)
}
