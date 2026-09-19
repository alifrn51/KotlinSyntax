package org.example.oop.cats

open class CatFamily (val legs: Int = 4){
    fun playWithMouse(){
        println("I'm playing with mouse")
    }

    open fun eat(){
        print("Eat")
    }
}