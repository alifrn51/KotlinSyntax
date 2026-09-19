package org.example.oop.corporation

class Assistant(id: Int, name: String, age: Int) :
    Worker(
        id = id,
        name = name,
        age = age,
        employeePosition = EmployeePosition.ASSISTANT
    ), Cleaner, Supplier {

    override fun work() {
        println("Assistant working...")
    }

    fun bringCoffee(drinkName: String = "Cappuchino", count: Int = 1): String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("press the \"$drinkName\" button")
            println("Take coffee")
        }

        return drinkName
    }
}