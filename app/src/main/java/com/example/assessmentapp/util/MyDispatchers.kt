package com.example.assessmentapp.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MyDispatchers : IMyDispatchers {
    override val IO: CoroutineDispatcher = Dispatchers.IO
    override val Main: CoroutineDispatcher = Dispatchers.Main
    override val Computation: CoroutineDispatcher = Dispatchers.Default
}