package org.example.syntax

fun main() {

    print("Enter Month name: ")
    val monthName = readln().trim()

    val season = when (monthName) {
        "January", "February", "March" -> "Spring"
        "April", "May", "June" -> "Sumer"
        "July", "August", "September" -> "Autumn"
        "October", "November", "December" -> "Winter"
        else -> ""
    }


    if (season == "") {
        println("There is no such month")
    } else {
        println("Season $season")
    }
}