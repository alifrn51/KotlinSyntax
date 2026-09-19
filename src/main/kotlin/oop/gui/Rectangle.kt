package org.example.oop.gui

class Rectangle {
    val width: Int
    val height: Int

    constructor(): this(0)

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    constructor(size: Int):this(size, size)

    fun draw(){
        repeat(height) {
            repeat(width) {
                print("* ")
            }
            print("\n")
        }
    }
}