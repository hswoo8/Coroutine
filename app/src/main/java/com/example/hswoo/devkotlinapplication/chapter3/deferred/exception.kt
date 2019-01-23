package com.example.hswoo.devkotlinapplication.chapter3.deferred

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val deferred = GlobalScope.async {
        TODO("Not implemented yet!")
    }

    // Wait for it to fail
    delay(2000)
}