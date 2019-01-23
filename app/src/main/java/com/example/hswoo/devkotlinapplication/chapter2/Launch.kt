package com.example.hswoo.devkotlinapplication.chapter2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {

    val task = GlobalScope.launch {
        doSomething()
    }

    task.join()
    println("completed")


    suspend fun doSomething() {

    }
}

private suspend fun doSomething() {
    delay(100)
    println("Half-way to crash")
    delay(100)
    throw UnsupportedOperationException("Can't do")
}
