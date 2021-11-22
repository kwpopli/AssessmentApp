package com.example.assessmentapp.util

import kotlinx.coroutines.CoroutineDispatcher

interface IMyDispatchers {
    val IO: CoroutineDispatcher
    val Main: CoroutineDispatcher
    val Computation: CoroutineDispatcher
}