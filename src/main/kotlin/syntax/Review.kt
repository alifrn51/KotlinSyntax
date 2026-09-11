package org.example.syntax

fun main() {

    print("What wa your experience with us? (Please rate us from 1 to 5): ")
    val score = readln()

    print("Please leave a comment: ")
    val comment = readln()

    println("1. Thank you for opinion \n" +
    "2. You left us a rating of: ($score)\n" +
    "3. The text of your comment: ($comment)")

}