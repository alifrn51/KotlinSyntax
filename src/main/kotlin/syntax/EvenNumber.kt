package org.example.syntax

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20)

    for (number in numbers) {

        if(number % 2 == 0){
            println("\"$number\" is even")
        }

    }

}