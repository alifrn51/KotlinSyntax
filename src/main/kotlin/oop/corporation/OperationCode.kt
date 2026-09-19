package org.example.oop.corporation

enum class OperationCode(val title: String) {
    EXIT(title = "Exit"),
    REGISTER(title = "Register"),
    SHOW_ALL_LIST(title = "Show all list"),
    REMOVE_ITEM(title = "Remove item"),
    REGISTER_NEW_EMPLOYEE(title = "Register new employee"),
    FIRE_EMPLOYEE(title = "Fire employee"),
    SHOW_ALL_EMPLOYEE(title = "Show all employee employee"),
    CHANGE_SALARY(title = "Change salary")
}