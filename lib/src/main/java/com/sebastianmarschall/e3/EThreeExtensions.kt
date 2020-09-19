package com.sebastianmarschall.e3

import com.virgilsecurity.common.callback.OnCompleteListener
import com.virgilsecurity.common.callback.OnResultListener
import com.virgilsecurity.common.model.Completable
import com.virgilsecurity.common.model.Result
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


suspend fun Completable.await(): Boolean = suspendCoroutine { cont ->
    addCallback(object : OnCompleteListener {
        override fun onError(throwable: Throwable) {
            cont.resumeWithException(throwable)
        }

        override fun onSuccess() {
            cont.resume(true)
        }
    })
}


suspend fun <T> Result<T>.await(): T = suspendCoroutine { cont ->
    addCallback(object : OnResultListener<T> {
        override fun onError(throwable: Throwable) {
            cont.resumeWithException(throwable)
        }

        override fun onSuccess(result: T) {
            cont.resume(result)
        }
    })
}