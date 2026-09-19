package org.example.oop.filse

import java.io.File

fun main() {

    val file = File("todolist.txt")
    val list = mutableListOf<String>()

    while (true) {

        val operationCodes = OperationCode.entries
        print("Enter operation code. ")
        for ((index, type) in operationCodes.withIndex()) {
            print("$index -> ${type.title}")
            val separator = if (index < operationCodes.size - 1) ", " else ": "
            print(separator)
        }
        val operationCodeIndex = readln().toInt()
        val operationCode = operationCodes[operationCodeIndex]

        when (operationCode) {
            OperationCode.NEW_TASK -> {

                print("Write task: ")
                val task = readln()

                file.appendText("${task}\n")

            }

            OperationCode.TO_DO_LIST -> {
                val content = file.readText()
                val items = content.split("\n")

                list.addAll(items)

                for ((index, task) in list.withIndex()) {
                    if(task.isNotEmpty()){
                        print("$index -> ${task}\n")
                    }
                }
            }

            OperationCode.SHUTS_DOWN -> {
                break
            }
        }


    }

}