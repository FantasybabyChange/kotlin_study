package com.fantasybaby.kotlin.learn.channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

val channel = Channel<Int>()
suspend fun receive() {
    for (i in channel) {
        println("received $i")
    }
//    while (true) {
//        val receive = channel.receive()
//        println("--$receive")
//    }
}

suspend fun send(str :String) {
    for (x in 1..5) {
        println("$str send $x")
        channel.send(x)
    }
}

suspend fun main() {
    GlobalScope.launch {
        receive()
    }
    GlobalScope.launch {
        send("first")
    }
    channel.send(60)
    println("Done!")
//    Thread.sleep(10000)
    GlobalScope.launch {
        send("second")
    }
    Thread.sleep(10000)
}
