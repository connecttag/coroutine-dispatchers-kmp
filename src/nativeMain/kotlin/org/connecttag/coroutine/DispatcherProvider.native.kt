package org.connecttag.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

public actual object DefaultDispatcherProvider : DispatcherProvider {
    public actual override val main: CoroutineDispatcher get() = Dispatchers.Default
    public actual override val io: CoroutineDispatcher get() = Dispatchers.Default
    public actual override val default: CoroutineDispatcher get() = Dispatchers.Default
    public actual override val unconfined: CoroutineDispatcher get() = Dispatchers.Unconfined
}
