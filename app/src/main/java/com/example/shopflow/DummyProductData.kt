package com.example.shopflow.data

import com.example.shopflow.model.Product

object DummyProductData {
    fun getProducts(): List<Product> {
        return listOf(
            Product(
                "Facewash",
                299.0,
                "https://ik.imagekit.io/6ilngyaqa/1748274546776-fashwash_OwZuP0UIfo.jpg",
                true
            ),
            Product(
                "Serum",
                799.0,
                "https://ik.imagekit.io/6ilngyaqa/1748274587337-serum_ZvVU469SYq.jpg",
                true
            )
        )
    }
}
