package org.example.oop.corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Float,
    val wattage: Float,
) : ProductCard(name = name, brand = brand, price = price, productType = ProductType.APPLIANCE) {

    override fun toString(): String {
        return "Name: $name, Brand: $brand, Price: $price,Wattage: $wattage Product type: $productType"
    }
}