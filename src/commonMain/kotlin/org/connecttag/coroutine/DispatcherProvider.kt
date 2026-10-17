package org.connecttag.coroutine

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provides coroutine dispatchers through an injectable contract.
 */
public interface DispatcherProvider {
    public val main: CoroutineDispatcher
    public val io: CoroutineDispatcher
    public val default: CoroutineDispatcher
    public val unconfined: CoroutineDispatcher
}

/**
 * Default dispatcher provider resolved by each platform.
 */
public expect object DefaultDispatcherProvider : DispatcherProvider {
    override val main: CoroutineDispatcher
    override val io: CoroutineDispatcher
    override val default: CoroutineDispatcher
    override val unconfined: CoroutineDispatcher
}

/**
 * Dispatcher provider implementation suitable for unit and integration testing.
 */
public class TestDispatcherProvider(
    private val testDispatcher: CoroutineDispatcher,
) : DispatcherProvider {
    override val main: CoroutineDispatcher get() = testDispatcher
    override val io: CoroutineDispatcher get() = testDispatcher
    override val default: CoroutineDispatcher get() = testDispatcher
    override val unconfined: CoroutineDispatcher get() = testDispatcher
}
