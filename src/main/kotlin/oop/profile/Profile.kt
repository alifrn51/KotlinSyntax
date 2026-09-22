package org.example.oop.profile

fun main() {


    val p1 = Person(name = "", lastName = "", age = 0, height = 0, weight = 0)
    val p2 = Person(name = "", lastName = "", age = 0, height = 0, weight = 0)


    val list = mutableSetOf<Person>()
    list.add(p1)
    list.add(p2)
    val newPerson = p1.copy(name = "ALiFrn")
    list.add(newPerson)
    println(p1 == p2)

    for (item in list){
        println(item.toString())
    }


}