package org.example.oop.corporation

class FoodCard(
    name: String,
    brand: String,
    val caloric: String,
    price: Float
) : ProductCard(name = name, brand = brand, price = price, productType = ProductType.FOOD) {

    override fun toString(): String {
        return "Name: $name, Brand: $brand, Price: $price, Caloric: $caloric, Product type: $productType"
    }
}