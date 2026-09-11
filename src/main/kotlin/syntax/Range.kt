package org.example.syntax

fun main() {

    val numbers = 0..1000 step 2
    print("Enter number: ")
    val searchNum = readln().toInt()
    val result = searchNum in numbers

    println(result)

}