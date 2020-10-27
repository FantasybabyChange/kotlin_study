package com.fantasybaby.kotlin.learn.channel

import kotlinx.coroutines.channels.Channel

val channel = Channel<Int>()


/*

launch {
    for (x in 1..5) channel.send(x * x)
}
repeat(5) { println(channel.receive()) }
println("Done!")*/
