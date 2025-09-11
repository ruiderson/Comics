package com.example.comics.presentation.interaction

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.StateFlow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class SavableStateFlow<T> internal constructor(
    private val savedStateHandle: SavedStateHandle,
    private val key: String,
    initialValue: T,
) {
    private val state: StateFlow<T> = savedStateHandle.getStateFlow(
        key = key,
        initialValue = initialValue
    )

    val value = state.value

    fun asStateFlow(): StateFlow<T> = state

    fun update(transform: (T) -> T) {
        savedStateHandle[key] = transform(state.value)
    }
}

private fun keyOf(owner: Any, property: KProperty<*>, key: String?): String {
    val ownerName = owner::class.qualifiedName ?: owner::class.simpleName
    return buildString {
        append(ownerName).append('.').append(property.name)
        if (!key.isNullOrEmpty()) append('.').append(key)
    }
}

fun <T> SavedStateHandle.savableStateFlowOf(
    initial: T,
    key: String? = null
): ReadOnlyProperty<Any, SavableStateFlow<T>> =
    object : ReadOnlyProperty<Any, SavableStateFlow<T>> {
        private var cached: SavableStateFlow<T>? = null
        private var cachedKey: String? = null

        override fun getValue(thisRef: Any, property: KProperty<*>): SavableStateFlow<T> {
            val stateKey = keyOf(thisRef, property, key)
            if (cached != null && cachedKey == stateKey) return (cached as SavableStateFlow<T>)
            return SavableStateFlow(this@savableStateFlowOf, stateKey, initial).also {
                cached = it
                cachedKey = stateKey
            }
        }
    }