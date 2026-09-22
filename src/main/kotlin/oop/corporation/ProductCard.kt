package org.example.oop.corporation

abstract class ProductCard(
   open val name: String,
   open val brand: String ,
   open val price: Float,
   val productType: ProductType
){
   fun printInfo(){
      println(this)
   }

}