package org.example.oop.cats

fun main() {

    val cat = Cat(name = "Luffy")
    println(cat.name)
    println(cat.legs)

    val lion = Lion(countIdPride = 25)
    println(lion.countIdPride)
    println(lion.legs)

    lion.playWithMouse()
    cat.eat()
    lion.eat()

}