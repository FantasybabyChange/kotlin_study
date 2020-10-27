package com.fantasybaby.kotlin.learn.channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
val channel = Channel<Int>()
suspend fun receive(){
     for (i in channel) {
         println(i)
     }
}
suspend fun main() {

    GlobalScope.launch {
        for (x in 1..5) channel.send(x * x)
    }
    receive()
    println("Done!")
}
