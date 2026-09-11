package org.example.syntax

fun main() {

    print("The weather is good? (true/false): ")
    val weather = readln().toBoolean()
    println("What time is it? ")
    val times = readln().toInt()

    // 18 ... 5
    val isNight = times !in 6..18
    val isDay = times in 6..18

    if(!isNight && weather) {
        println("Go to Walking!")
    }else if(isNight) {
        println("GO to sleeping!")
    }else if(isDay) {
        println("Go to read a bool!")
    }



}