package org.example.syntax

import kotlin.random.Random

fun main() {

    var win = false
    val randomInt = Random.nextInt(0, 100)

    while (!win) {

        print("Enter number from 0 to 100: ")
        val guessNumber = readln().toInt()

        if(guessNumber > randomInt) {
            println("Your number is higher")
        }else if(guessNumber < randomInt) {
            println("Your number is lower")
        }else{
            println("You Win!")
            win = true
        }

    }

}