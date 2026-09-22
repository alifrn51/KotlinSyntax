package org.example.oop.corporation

import java.io.File

object WorkersRepository {

    private val employeeFile = File("employes.txt")

    private val _workers = getAllEmployee()
    val workers
        get() = _workers.toList()

    fun changeSalary(id: Int, salary: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(salary = salary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun changeAge(id: Int, age: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(age = age)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }


    fun fireEmployee(id: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                _workers.remove(worker)
                println("The employee with ID $id fired!")
                break
            }
        }
    }


    private fun getAllEmployee(): MutableSet<Worker> {

        val content = employeeFile.readText().trim()

        val employees = mutableSetOf<Worker>()

        val items = content.split("\n")

        for (item in items) {
            if (item.isEmpty()) {
                println("Employee list is empty!")
                break
            }
            val properties = item.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val employeePosition = EmployeePosition.valueOf(properties.last())
            val worker = when (employeePosition) {
                EmployeePosition.ASSISTANT -> Assistant(id = id, name = name, age = age, salary = salary)
                EmployeePosition.DIRECTOR -> Director(id = id, name = name, age = age, salary = salary)
                EmployeePosition.CONSULTANT -> Consultant(id = id, name = name, age = age, salary = salary)
                EmployeePosition.ACCOUNTANT -> Accountant(id = id, name = name, age = age, salary = salary)
            }
            employees.add(worker)
        }

        return employees

    }

    fun getAssistantEmployee(id: Int): Assistant? {

        for (worker in _workers ){
            if(worker.id == id && worker.employeePosition == EmployeePosition.ASSISTANT)
                return worker as Assistant
        }

        return null
    }

    fun registerNewEmployee(newWorker: Worker) {
        _workers.add(newWorker)
    }

    fun saveChanges() {
        val content = StringBuffer()

        for (worker in _workers) {
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.employeePosition}\n")
        }
        employeeFile.writeText(content.toString())
    }


}