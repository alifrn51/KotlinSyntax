package org.example.oop.profile

data class Person(
    val name: String = "",
    val lastName: String,
    val age: Int,
    val height: Int,
    val weight: Int,
) {

    val fullName: String
        get() = "$name $lastName"

    fun sayHello() {
        println("Hello, I'm <$name>! and I'm $age years old")
    }

}