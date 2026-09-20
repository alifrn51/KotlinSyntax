package org.example.oop.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val employeePosition: EmployeePosition
){

    var salary: Int = 15000
        set(value) {
            if(value < this.salary) println("The new salary is to small...")
            else field = value
        }

    fun printInfo(){
        println("ID: ${id}, Name: ${name}, Age: ${age}, Salary: ${salary}, Position: ${employeePosition.title}")
    }

    open fun work(){
        println("I'm working...")
    }
}