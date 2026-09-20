package org.example.oop.corporation

import java.io.File

class ProductCardRepository {


    private val productFile = File("product_cards.txt")


    fun removeProductItem(name: String) {

        val productCards = readAllProductList()

        for (productCard in productCards) {
            if (productCard.name == name) {
                productCards.remove(productCard)
                println("The product with name $name removed!")
                break
            }
        }

        productFile.writeText("")

        for (productCard in productCards) {
            saveProductCardToFile(productCard)
        }

    }

    fun readAllProductList(): MutableList<ProductCard> {

        val list = mutableListOf<ProductCard>()
        val content = productFile.readText().trim()
        val items = content.split("\n")

        for (item in items) {
            if (item.isEmpty()){
                println("Product list is empty!")
                break
            }
            val properties = item.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toFloat()
            val type = properties.last()
            val productType = ProductType.valueOf(type)

            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3]
                    FoodCard(name = name, brand = brand, price = price, caloric = caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toFloat()
                    ApplianceCard(name = name, brand = brand, price = price, wattage = wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoesCard(name = name, brand = brand, price = price, size = size)
                }
            }

            list.add(productCard)
        }
        return list
    }


    private fun saveProductCardToFile(productCard: ProductCard) {

        productFile.appendText("${productCard.name}%")
        productFile.appendText("${productCard.brand}%")
        productFile.appendText("${productCard.price}%")


        when (productCard) {
            is FoodCard -> {
                productFile.appendText("${productCard.caloric}%")
            }

            is ApplianceCard -> {
                productFile.appendText("${productCard.wattage}%")
            }

            is ShoesCard -> {
                productFile.appendText("${productCard.size}%")
            }
        }

        productFile.appendText("${productCard.productType}\n")

    }

    fun saveProductCard(productCard: ProductCard)
    {
        saveProductCardToFile(productCard)
    }
}