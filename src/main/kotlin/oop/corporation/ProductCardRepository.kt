package org.example.oop.corporation

import java.io.File

object ProductCardRepository {


    private val productFile = File("product_cards.txt")
    private val _products = getAllProducts()
    val products
        get() = _products.toList()


    fun removeProductItem(name: String) {

        for (productCard in _products) {
            if (productCard.name == name) {
                _products.remove(productCard)
                println("The product with name $name removed!")
                break
            }
        }
    }

    private fun getAllProducts(): MutableSet<ProductCard> {

        val list = mutableSetOf<ProductCard>()
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

    fun saveChanges(){
        val content = StringBuilder()

        for (productCard in _products){

            content.append("${productCard.name}%${productCard.brand}%${productCard.price}%")
            when (productCard) {
                is FoodCard -> {
                    content.append("${productCard.caloric}%")
                }

                is ApplianceCard -> {
                    content.append("${productCard.wattage}%")
                }

                is ShoesCard -> {
                    content.append("${productCard.size}%")
                }
            }

            content.append("${productCard.productType}\n")
        }
    }


    fun registerProductCard(productCard: ProductCard)
    {
        _products.add(productCard)
    }


}