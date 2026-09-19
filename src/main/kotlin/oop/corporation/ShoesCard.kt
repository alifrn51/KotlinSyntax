package org.example.oop.corporation

class ShoesCard(
    name: String,
    brand: String,
    price: Float,
    val size: Float,
) : ProductCard(name = name,brand = brand, price = price, productType = ProductType.SHOE) {

    override fun toString(): String {
        return "Name: $name, Brand: $brand, Price: $price,Size: $size, Product type: $productType"
    }
}