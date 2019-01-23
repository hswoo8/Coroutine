package com.example.hswoo.devkotlinapplication.chapter3.deferred.exception.await

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {
    val deferred = GlobalScope.async {
        TODO("Not implemented yet!")
    }

    // Let it fail
    deferred.await()
}