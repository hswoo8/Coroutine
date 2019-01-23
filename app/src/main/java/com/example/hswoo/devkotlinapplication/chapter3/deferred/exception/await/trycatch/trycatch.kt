package com.example.hswoo.devkotlinapplication.chapter3.deferred.exception.await.trycatch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val deferred = GlobalScope.async {
        val asdf = 23
        asdf

    }

    try {
        val r = deferred.await()
        println(r)
    } catch (throwable: Throwable) {
        println("Deferred cancelled due to ${throwable.message}")
    }
}