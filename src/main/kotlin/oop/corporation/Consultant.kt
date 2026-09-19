package org.example.oop.corporation

import kotlin.random.Random

class Consultant(id: Int, name: String, age: Int = 0) : Worker(
    id = id,
    name = name,
    age = age,
    employeePosition = EmployeePosition.CONSULTANT
) {

    override fun work() {
        println("Consultant working...")
    }

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