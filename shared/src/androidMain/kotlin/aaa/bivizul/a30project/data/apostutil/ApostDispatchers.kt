package aaa.bivizul.a30project.data.apostutil

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val uiDispatcher: CoroutineContext = Dispatchers.Main
actual val ioDispatcher: CoroutineContext = Dispatchers.IO