package org.example.oop.corporation

import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int
) : Worker(id = id, name = name, age = age, employeePosition = EmployeePosition.ACCOUNTANT), Cleaner, Supplier{

    private val productFile = File("product_cards.txt")
    private val workersRepository = WorkersRepository()

    override fun work() {


        while (true) {

            val operationCodes = OperationCode.entries

            println("Enter the operation code. ")

            for ((index, type) in operationCodes.withIndex()) {
                print("$index -> $type")
                val separator = if (index < operationCodes.size - 1) "\n" else ": "
                print(separator)
            }

            val operationCodeIndex = readln().toInt()
            val operationCode = operationCodes[operationCodeIndex]


            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER -> registerNewItem()
                OperationCode.SHOW_ALL_LIST -> showAllList()
                OperationCode.REMOVE_ITEM -> removeItem()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee()
                OperationCode.SHOW_ALL_EMPLOYEE -> showAllEmployee()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }

        }

    }

    private fun changeSalary() {
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val salary = readln().toInt()

        workersRepository.changeSalary(id = id, salary = salary)

    }

    private fun showAllEmployee() {

        val employees = workersRepository.getAllEmployee()

        for (employee in employees){
            employee.printInfo()
        }

    }

    private fun fireEmployee() {

        print("Enter employee's id of fire: ")
        val id = readln().toInt()

        workersRepository.fireEmployee(id = id
        )
    }

    private fun registerNewEmployee() {

        val employeePositions = EmployeePosition.entries
        print("Choose position. ")

        for ((index, type) in employeePositions.withIndex()) {
            print("$index -> $type")
            val separator = if (index < employeePositions.size - 1) ", " else ": "
            print(separator)
        }

        val employeeTypeIndex = readln().toInt()
        val employeeType = employeePositions[employeeTypeIndex]

        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()

        val worker = when (employeeType) {
            EmployeePosition.ASSISTANT -> {
                Assistant(id = id, name = name, age = age)
            }

            EmployeePosition.DIRECTOR -> {
                Director(id = id, name = name, age = age)
            }

            EmployeePosition.CONSULTANT -> {
                Consultant(id = id, name = name, age = age)
            }

            EmployeePosition.ACCOUNTANT -> {
                Accountant(id = id, name = name, age = age)
            }
        }

        workersRepository.saveEmployee(worker)
    }

    private fun removeItem() {
        print("Enter name item to remove: ")
        val name = readln()
        val productCards = readAllList()

        for (productCard in productCards) {
            if (productCard.name == name) {
                productCards.remove(productCard)
                println("The product with name $name removed!")
                break
            }
        }

        productFile.writeText("")

        for (productCard in productCards) {
            saveProductCardToFile(productCard)
        }

    }

    private fun readAllList(): MutableList<ProductCard> {

        val list = mutableListOf<ProductCard>()
        val content = productFile.readText().trim()
        val items = content.split("\n")

        for (item in items) {
            if (item.isEmpty()){
                println("Product list is empty!")
                break
            }
            val properties = item.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toFloat()
            val type = properties.last()
            val productType = ProductType.valueOf(type)

            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3]
                    FoodCard(name = name, brand = brand, price = price, caloric = caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toFloat()
                    ApplianceCard(name = name, brand = brand, price = price, wattage = wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoesCard(name = name, brand = brand, price = price, size = size)
                }
            }

            list.add(productCard)
        }
        return list
    }

    private fun saveProductCardToFile(productCard: ProductCard) {

        productFile.appendText("${productCard.name}%")
        productFile.appendText("${productCard.brand}%")
        productFile.appendText("${productCard.price}%")


        when (productCard) {
            is FoodCard -> {
                productFile.appendText("${productCard.caloric}%")
            }

            is ApplianceCard -> {
                productFile.appendText("${productCard.wattage}%")
            }

            is ShoesCard -> {
                productFile.appendText("${productCard.size}%")
            }
        }

        productFile.appendText("${productCard.productType}\n")

    }

    private fun showAllList() {

        val list = readAllList()
        for (item in list) {
            item.printInfo()
        }

    }

    private fun registerNewItem() {

        val productTypes = ProductType.entries

        print("Enter the product type.")

        for ((index, type) in productTypes.withIndex()) {
            print(" $index -> ${type.title}")
            val separator = if (index < productTypes.size - 1) ", " else ": "
            print(separator)
        }

        val productTypeIndex = readln().toInt()
        println()
        val productType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val name = readln()
        print("Enter the product brand: ")
        val brand = readln()
        print("Enter the product price: ")
        val price = readln().toFloat()

        val card = when (productType) {
            ProductType.FOOD -> { // Food type
                val caloric = readProductValue("Caloric")
                FoodCard(name = name, brand = brand, price = price, caloric = caloric)
            }

            ProductType.APPLIANCE -> { // Appliance type
                val wattage = readProductValue("Wattage").toFloat()
                ApplianceCard(name = name, brand = brand, price = price, wattage = wattage)
            }

            ProductType.SHOE -> { // Shoe
                val size = readProductValue("Size").toFloat()
                ShoesCard(name = name, brand = brand, price = price, size = size)
            }
        }

        saveProductCardToFile(card)
    }

    private fun readProductValue(valueName: String): String {
        print("Enter the product $valueName: ")
        val value = readln()
        println()
        return value
    }


}