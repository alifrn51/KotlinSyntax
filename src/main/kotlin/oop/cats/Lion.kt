package org.example.oop.cats

class Lion(val countIdPride: Int): CatFamily() {
    override fun eat() {
        println("I eat an antelope")
    }
}