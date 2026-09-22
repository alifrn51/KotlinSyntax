package org.example.oop.corporation

data class Director(
    override val id:Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(id= id, name = name, age = age, employeePosition = EmployeePosition.DIRECTOR,salary = salary) {

    override fun work(){
        println("Director working...")
    }
    override fun copy(
        id: Int,
        name: String,
        age: Int,
        employeePosition: EmployeePosition,
        salary: Int
    ): Worker = Director(id = id,name = name, age = age, salary = salary)



    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()

        println("Tanks, ${assistant.name}! The $drinkName is very tasty.")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("Consultant ${consultant.name} served $count clients")
    }

}