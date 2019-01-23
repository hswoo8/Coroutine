package com.example.hswoo.devkotlinapplication.chapter2

import kotlinx.coroutines.*


@InternalCoroutinesApi
@ExperimentalCoroutinesApi
fun main(args: Array<String>) = runBlocking {
//    val task = GlobalScope.async {
//        doSomething()
//    }

    // This code will have the exception be propagated
//    task.await()
//    println("Completed")

    val task = GlobalScope.launch {
        doSomething()
    }


    // This code will wait for the async to end and validate its output.
    // Comment line `15` for this to work
    task.join()
        println("Completed")

    // If the code below executes the `else` branch, please replace
    // `isCancelled` with `isCompletedExceptionally`. For more info see
    // https://github.com/Kotlin/kotlinx.coroutines/issues/220
    if (task.isCancelled) {
        val exception = task.getCancellationException()
        println("Error with message: ${exception?.message}")
    } else {
        println("Success")
    }
}

private fun doSomething() {
    throw UnsupportedOperationException("Can't do")
}
