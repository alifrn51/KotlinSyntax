package org.example.oop.corporation

fun main() {


    val workerRepository = WorkersRepository
//    for (worker in workerRepository.workers){
//
//        worker.work()
//    }

    val assistans = workerRepository.getAssistantEmployee(23)
    val salary = assistans?.salary ?: 0
    println("Salary = $salary")
}

fun printIn(): Nothing{
    throw Exception()
}

