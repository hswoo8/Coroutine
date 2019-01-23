package com.example.hswoo.devkotlinapplication.chapter2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val netDispatcher = newSingleThreadContext(name = "ServiceCall")

    val task = launch {
        doSomething1()
    }

    task.join()

//    if (task.isCancelled){
//        val message = task.getCancellationException()
//        println(message)
//    }


}

private suspend fun doSomething1() {
    delay(100)
    println("Half-way to crash")
    delay(100)
    throw UnsupportedOperationException("Can't do")
}