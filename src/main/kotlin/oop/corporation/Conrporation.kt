package org.example.oop.corporation

fun main() {


    val card = Accountant(id = 12, name = "ALi", age = 26)
    card.work()

    val accountant = Accountant(id = 1, name = "Alex", age = 20)
    accountant.work()
    val employees = accountant.getAllEmployee()

    for (employee in employees){
        if(employee is Cleaner){
            employee.clean()
        }
    }

}