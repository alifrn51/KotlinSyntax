package org.example.oop.corporation

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    val employeePosition: EmployeePosition,
    open val salary: Int = 15000,
) {

    abstract fun copy(
        id: Int = this.id,
        name: String = this.name,
        age: Int = this.age,
        employeePosition: EmployeePosition = this.employeePosition,
        salary: Int = this.salary
    ): Worker

    fun printInfo() {
        println("ID: ${id}, Name: ${name}, Age: ${age}, Salary: ${salary}, Position: ${employeePosition.title}")
    }

    open fun work() {
        println("I'm working...")
    }

    override fun equals(other: Any?): Boolean {

        return other is Worker && this.id == other.id

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + age
        result = 31 * result + salary
        result = 31 * result + name.hashCode()
        result = 31 * result + employeePosition.hashCode()
        return result
    }
}