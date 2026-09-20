package org.example.oop.corporation

enum class OperationCode(val title: String) {
    EXIT(title = "Exit"),
    REGISTER_NEW_PRODUCT(title = "Register new product"),
    SHOW_ALL_PRODUCT(title = "Show all product"),
    REMOVE_PRODUCT(title = "Remove product"),
    REGISTER_NEW_EMPLOYEE(title = "Register new employee"),
    FIRE_EMPLOYEE(title = "Fire employee"),
    SHOW_ALL_EMPLOYEE(title = "Show all employee employee"),
    CHANGE_SALARY(title = "Change salary")
}