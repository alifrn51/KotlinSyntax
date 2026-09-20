package org.example.oop.corporation

import java.io.File

class WorkersRepository {

    private val employeeFile = File("employes.txt")

    fun changeSalary(id: Int, salary: Int) {
        val employees = getAllEmployee().toMutableList()
        for (employee in employees) {
            if (employee.id == id) {
                employee.salary = salary
                employeeFile.writeText(" ")
            }
            saveEmployeeToFile(employee)
        }
    }


    fun fireEmployee(id: Int) {
        val employees = getAllEmployee().toMutableList()
        for (employee in employees) {
            if (employee.id == id) {
                employees.remove(employee)
                employeeFile.writeText(" ")
                println("The employee with ID $id fired!")
                break
            }
        }

        for (employee in employees) {
            saveEmployeeToFile(employee)
        }
    }


    fun getAllEmployee(): List<Worker> {

        val content = employeeFile.readText().trim()
        if (content.isEmpty()) {
            println("Employee list is empty!")
            return emptyList()
        }
        val employees = mutableListOf<Worker>()

        val items = content.split("\n")

        for (item in items) {
            val properties = item.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val employeePosition = EmployeePosition.valueOf(properties.last())
            val worker = when (employeePosition) {
                EmployeePosition.ASSISTANT -> Assistant(id = id, name = name, age = age)
                EmployeePosition.DIRECTOR -> Director(id = id, name = name, age = age)
                EmployeePosition.CONSULTANT -> Consultant(id = id, name = name, age = age)
                EmployeePosition.ACCOUNTANT -> Accountant(id = id, name = name, age = age)
            }
            worker.salary = salary
            employees.add(worker)
        }

        return employees

    }


    private fun saveEmployeeToFile(worker: Worker) {

        employeeFile.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%")
        employeeFile.appendText("${worker.employeePosition}\n")

    }

    fun saveEmployee(worker: Worker) {

        saveEmployeeToFile(worker)

    }


}