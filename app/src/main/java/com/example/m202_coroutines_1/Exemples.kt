package com.example.m202_coroutines_1

import kotlinx.coroutines.*


// Exercice 1

//val C = GlobalScope.launch {
//
//    for(i in 0..10) {
//        println("C$i")
//        delay(1000L)
//
//    }
//    println("Fin Coroutine 1")
//
//
//}
//
//val B = GlobalScope.launch {
//
//    for(i in 0..7) {
//        println("B$i")
//        delay(1000L)
//
//    }
//    println("Fin Coroutine 2")
//
//
//}
//
//val D = GlobalScope.launch {
//    B.join()
//
//    for(i in 0..10) {
//        println("D$i")
//        delay(1000L)
//
//    }
//    println("Fin Coroutine 3")
//
//
//}
//
//fun main()= runBlocking {
//
//
//    joinAll(C, B, D)
//}

// Exercice 2

val C = GlobalScope.launch {

    for (i in 0..15){
        println("C$i")
        delay(1000L)
    }

}


val D = GlobalScope.launch {
    for (i in 0..5){
        println("D$i")
        delay(1000L)
    }
    println("D is finish")



}

val M = GlobalScope.launch {

    D.join()
    println("M is Start")

    for (i in 0..5){
        println("M$i")
        delay(1000L)
    }

    println("M is finish")
    C.cancel()
    println("C is cancel")

}

val X = GlobalScope.launch {
    M.join()
    println("X is Start")

    for (i in 0..5){
        println("X$i")
        delay(1000L)
    }
    println("X is finish")


}


// Exercice 3
val Z = GlobalScope.launch {
    delay(4000)
    println("C is Start")

    for (i in 0..5){
        println("Z$i")
        delay(1000L)
    }

    println("C is finish")


}

val Y = GlobalScope.launch {
    delay(4000)

    for (i in 0..7){
        println("Y$i")
        delay(1000L)
    }

    W.cancel()



}

val W = GlobalScope.launch {
    Z.join()
    println("D is Start")


    for (i in 0..7){
        println("D$i")
        delay(1000L)
    }

    println("C is finish")


}
fun main() {
    runBlocking {

    joinAll(Z, Y, W)
}
}