package com.fantasybaby.kotlin.learn.channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

val channel = Channel<Int>()
suspend fun receive() {
//     for (i in channel) {
//         println(i)
//     }
    while (true) {
        val receive = channel.receive()
        println("--$receive")
    }
}

suspend fun send() {
    for (x in 1..5) channel.send(x * x)
}

suspend fun main() {
    GlobalScope.launch {
        receive()
    }
    GlobalScope.launch {
        send()
    }
    channel.send(60)
    println("Done!")
    Thread.sleep(10000)
    GlobalScope.launch {
        send()
    }
    Thread.sleep(10000)
}
