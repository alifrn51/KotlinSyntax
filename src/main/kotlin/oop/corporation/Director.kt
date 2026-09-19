package org.example.oop.corporation

class Director(
    id:Int,
    name: String,
    age: Int
) : Worker(id= id, name = name, age = age, employeePosition = EmployeePosition.DIRECTOR) {

    override fun work(){
        println("Director working...")
    }

    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()

        println("Tanks, ${assistant.name}! The $drinkName is very tasty.")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("Consultant ${consultant.name} served $count clients")
    }

}