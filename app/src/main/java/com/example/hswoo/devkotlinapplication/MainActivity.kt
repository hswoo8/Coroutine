package com.example.hswoo.devkotlinapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import kotlinx.coroutines.*
import java.lang.UnsupportedOperationException

import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        runBlocking {
            println("${Thread.activeCount()} threads active at the start")
            val time = measureTimeMillis {
                createCoroutines(3)
            }
            println("${Thread.activeCount()} threads active at end")
            println("Took $time ms")
        }
    }

    suspend fun createCoroutines(amount: Int) {
        val jobs = ArrayList<Job>()
        for (i in 1..amount) {
            jobs += GlobalScope.launch {
                println("Started $i in ${Thread.currentThread().name}")
                delay(1000)

                println("Finished $i in ${Thread.currentThread().name}")
            }
        }
        jobs.forEach {
            it.join()
        }
    }
}

