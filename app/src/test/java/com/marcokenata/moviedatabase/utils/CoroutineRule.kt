package com.marcokenata.moviedatabase.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class CoroutineRule : TestRule {

    private val coroutineDispatcher = TestCoroutineDispatcher()

    private val testCoroutineScope = TestCoroutineScope(coroutineDispatcher)

    override fun apply(base: Statement?, description: Description?): Statement  = object : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            Dispatchers.setMain(coroutineDispatcher)

            base?.evaluate()

            Dispatchers.resetMain()
            testCoroutineScope.cleanupTestCoroutines()
        }

    }

    fun runBlockingTest(block : suspend TestCoroutineScope.() -> Unit) {
        testCoroutineScope.runBlockingTest { block() }
    }

}