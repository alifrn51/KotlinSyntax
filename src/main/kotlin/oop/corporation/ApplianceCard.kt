package org.example.oop.corporation

data class ApplianceCard(
    override val name: String,
    override val brand: String,
    override val price: Float,
    val wattage: Float,
) : ProductCard(name = name, brand = brand, price = price, productType = ProductType.APPLIANCE)