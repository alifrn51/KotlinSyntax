package org.example

fun main() {

    print("Enter second: ")
    val second = readln().toInt()

    val hour = second / 3600
    val secondForMinutes = second % 3600
    val minute = secondForMinutes / 60
    val leftSecond = second % 60


    println("$hour:$minute:$leftSecond")

}