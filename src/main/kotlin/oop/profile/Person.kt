package org.example.oop.profile

class Person(
    var name: String,
    val lastName: String,
    val age: Int
) {

    val fullName: String
        get() = "$name $lastName"

    fun sayHello() {
        println("Hello, I'm <$name>! and I'm $age years old")
    }
}