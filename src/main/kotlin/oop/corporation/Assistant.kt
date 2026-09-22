package org.example.oop.corporation

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) :
    Worker(
        id = id,
        name = name,
        age = age,
        employeePosition = EmployeePosition.ASSISTANT,
        salary = salary
    ), Cleaner, Supplier {

    override fun work() {
        println("Assistant working...")
    }

    override fun copy(
        id: Int,
        name: String,
        age: Int,
        employeePosition: EmployeePosition,
        salary: Int
    ): Worker = Assistant(id = id,name = name, age = age, salary = salary)


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