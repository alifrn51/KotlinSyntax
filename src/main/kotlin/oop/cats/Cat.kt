package org.example.oop.cats

class Cat(val name: String): CatFamily() {
    override fun eat() {
        println("I eat whiskas")
    }
}