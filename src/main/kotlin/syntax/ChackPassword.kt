package org.example.syntax

fun main() {

    print("Enter password: ")
    val password = readln().toCharArray()

    var containsLetterNumber = 0
    var containsDigitNumber = 0
    var containsSpecialSymbolNumber = 0

    for (symbol in password) {
        if(symbol.isLetter()){
            containsLetterNumber++
        }
        if(symbol.isDigit()){
            containsDigitNumber++
        }
        if(!symbol.isLetterOrDigit()){
            containsSpecialSymbolNumber++
        }
    }

    if(containsLetterNumber >= 3 && containsDigitNumber >= 2 && containsSpecialSymbolNumber >= 5){
        println("Password is valid")
    }else{
        println("Password is invalid")
    }


}