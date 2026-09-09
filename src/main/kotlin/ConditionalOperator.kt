package org.example

fun main() {

    print("Enter first person age: ")
    val firstName = readln().toInt()

    print("Enter second person age: ")
    val second = readln().toInt()

    if(firstName > second) {
        println(" The first person is older tha the second.")
    }else if(firstName < second) {
        println(" The second person is older than the first.")
    }else{
        println("The ages of the people are the same.")
    }
}