package org.example.syntax

fun main() {

    print("HOw old are you? : ")
    val age = readln().toInt()
    var temp = age
  /*  while(temp < 18) {

        println("We are waiting for one year")
        temp++
    }*/

    repeat(18 - age) {

            println("We are waiting for one year")

    }

    println("You can go to the cinema")

}