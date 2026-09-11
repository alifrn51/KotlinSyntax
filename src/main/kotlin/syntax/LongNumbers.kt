package org.example.syntax

fun main() {

    print("Enter year: ")
    val year = readln().toLong()

    val second = year * 365 * 24 * 60 * 60

    println("\'$year\' year is $second seconds")

}