package org.example.oop.corporation

import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    employeePosition = EmployeePosition.CONSULTANT,
    salary = salary
) {

    override fun work() {
        println("Consultant working...")
    }

    override fun copy(
        id: Int,
        name: String,
        age: Int,
        employeePosition: EmployeePosition,
        salary: Int
    ): Worker = Consultant(id = id,name = name, age = age, salary = salary)


    fun serveCustomers(): Int {

        val serveCustomersCount = Random.nextInt(1, 10)

        repeat(serveCustomersCount) {
            print("Client serve! ")
        }
        println()

        return serveCustomersCount

    }

    fun sayHello() {
        print(
            "Hello,My name is $name!${
                if (age > 1) {
                    "i'm $age years old."
                } else ""
            }"
        )
    }
}