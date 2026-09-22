package org.example.oop.corporation

data class FoodCard(
   override val name: String,
   override val brand: String,
   override val price: Float,
    val caloric: String,
) : ProductCard(name = name, brand = brand, price = price, productType = ProductType.FOOD)