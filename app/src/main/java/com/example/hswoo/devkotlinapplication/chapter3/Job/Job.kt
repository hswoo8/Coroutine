package com.example.hswoo.devkotlinapplication.chapter3.Job

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(5000)
    }

    job.start()
    delay(2000)
    job.cancel(cause = Exception("Timeout!"))

    if (job.isCancelled) {
        val cancellationException = job.getCancellationException()
    }

}