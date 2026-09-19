package org.example.oop.profile

fun main() {


    val firstPerson = Person(name = "Ali", lastName = "Foroozan", age = 26)
    val secondPerson = Person(name = "Saeedeh", lastName = "Erfanian",age = 27)

    println(firstPerson.fullName)
    println(secondPerson.fullName)
    firstPerson.name = "zari"
    secondPerson.name = "Fati"
    println(firstPerson.fullName)
    println(secondPerson.fullName)

}