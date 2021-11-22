package com.example.assessmentapp.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@ExperimentalCoroutinesApi
class TestMyDispatchers : IMyDispatchers {
    override val IO: CoroutineDispatcher = TestCoroutineDispatcher()
    override val Main: CoroutineDispatcher = TestCoroutineDispatcher()
    override val Computation: CoroutineDispatcher = TestCoroutineDispatcher()
}