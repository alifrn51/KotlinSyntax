package org.example.oop.corporation

abstract class ProductCard(
   var name: String,
   var brand: String ,
   var price: Float,
   val productType: ProductType
){
   fun printInfo(){
      print(this)
   }

}