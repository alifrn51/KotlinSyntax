package org.example.oop.corporation

data class ShoesCard(
    override val name: String,
    override val brand: String,
    override val price: Float,
    val size: Float,
) : ProductCard(name = name,brand = brand, price = price, productType = ProductType.SHOE)