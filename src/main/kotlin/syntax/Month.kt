package org.example.syntax

fun main() {

    print("Enter month number: ")
    val enterNumber = readln().toInt()

    val month = when (enterNumber) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> ""
    }

    val season = when(enterNumber) {
        1,2,3 -> "Spring"
        4,5,6 -> "Summer"
        7,8,9 -> "Autumn"
        10,11,12 -> "Winter"
        else -> ""
    }

    if (enterNumber in 1..12) {
        println("You entered index $enterNumber, which corresponds to the month of $month")
        println("Season $season")
    } else {
        println("You entered index $enterNumber, There is no month with such as index")
        println("There is no such month")
    }
}