package org.example.oop.corporation

class Accountant(
    id: Int,
    name: String,
    age: Int
) : Worker(id = id, name = name, age = age, employeePosition = EmployeePosition.ACCOUNTANT), Cleaner, Supplier{

    private val workersRepository = WorkersRepository()
    private val productCardRepository = ProductCardRepository()

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
                OperationCode.REGISTER_NEW_PRODUCT -> registerNewProductItem()
                OperationCode.SHOW_ALL_PRODUCT -> showAllList()
                OperationCode.REMOVE_PRODUCT -> removeProductItem()
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

    private fun removeProductItem() {
        print("Enter name item to remove: ")
        val name = readln()
        productCardRepository.removeProductItem(name)
    }


    private fun showAllList() {

        val list = productCardRepository.readAllProductList()
        for (item in list) {
            item.printInfo()
        }

    }

    private fun registerNewProductItem() {

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

       productCardRepository.saveProductCard(card)
    }

    private fun readProductValue(valueName: String): String {
        print("Enter the product $valueName: ")
        val value = readln()
        println()
        return value
    }


}