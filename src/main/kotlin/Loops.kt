package org.example

fun main() {
    
    val names = listOf("Alice", "Bob", "Charlie")
    
    var nameFound = false

    print("Search: ")

    val searchString = readln()
    
    var index = 0
    while(index < names.size) {
        
        val name = names[index]

        println(name)

        if (name == searchString) {
            nameFound = true
            break
        }
        
        index++
    }

    println("Name found: $nameFound")
    
}