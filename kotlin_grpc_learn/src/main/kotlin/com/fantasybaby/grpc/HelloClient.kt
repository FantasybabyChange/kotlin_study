package com.fantasybaby.grpc

import com.fantasybaby.Hi
import com.fantasybaby.TestServiceCoroutineGrpc
import com.fantasybaby.TestServiceGrpc
import io.grpc.ManagedChannelBuilder
import io.grpc.ServerBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking


/**
 *2020/11/8
 *@authorfantasybaby
 *
 **/
@ExperimentalCoroutinesApi
fun main() {
    val port = 6565
//    val server = ServerBuilder.forPort(port)
//            .addService(Hellos())
//            .build()
//            .start()
//
//    val channel = ManagedChannelBuilder.forAddress("localhost", 6565)
//            .usePlaintext()
//            .build()
//    val client = MessageServiceCoroutineGrpc
//            .MessageServiceCoroutineStub.newStub(channel)
//    println("--- Bidirectional Stream start ---")
//    runBlocking {
//        val (requestChannel, responseChannel) = client.bidirectionalStream()
//        listOf("hello", "kotlin", "proto").forEach {
//            requestChannel.send {
//                message = it
//            }
//        }
//        requestChannel.close()
//        responseChannel.consumeEach {
//            println(it.message)
//        }
//    }
//    println("--- Bidirectional Stream finish ---")
//    println("--- Client Stream start ---")
//    runBlocking {
//        val (requestChannel, response) = client.clientStream()
//        listOf("hello", "kotlin", "proto").forEach {
//            requestChannel.send {
//                message = it
//            }
//        }
//        requestChannel.close()
//        println(response.await().message)
//    }
//    println("--- Client Stream finish ---")
//    println("--- Server Stream start ---")
//    runBlocking {
//
//        client.serverStream(request).consumeEach {
//            println(it.message)
//        }
//    }
//    println("--- Server Stream finish ---")
//    server.shutdown()
//    val request = Req{
//        message = "kproto"
//    }
    val channel = ManagedChannelBuilder.forAddress("localhost", 6565)
            .usePlaintext()
            .build()
    val build = Hi.Req.newBuilder().setReq("123").build()
    runBlocking {

        TestServiceCoroutineGrpc.newStub(channel).test { req = "123" }
    }
}