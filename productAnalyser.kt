// Product Analyzer with Higher-Order Functions

// -------------------------------
// TODO 1: Define Product class
// -------------------------------
data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val stock: Int
)


// -------------------------------
// TODO 2: Higher-order function to apply discount
// -------------------------------
fun applyDiscount(
    products: List<Product>,
    discountFunction: (Double) -> Double
): List<Product> {

    return products.map { product ->
        product.copy(price = discountFunction(product.price))
    }
}


// -------------------------------
// TODO 3: Higher-order function to filter products
// -------------------------------
fun filterProducts(
    products: List<Product>,
    condition: (Product) -> Boolean
): List<Product> {

    return products.filter(condition)
}


// -------------------------------
// TODO 4 & 5: Main logic
// -------------------------------
fun main() {

    // Sample product list
    val products = listOf(
        Product("Laptop", "Electronics", 100000.0, 5),
        Product("Phone", "Electronics", 50000.0, 15),
        Product("Chair", "Furniture", 2000.0, 25),
        Product("Table", "Furniture", 3000.0, 5),
        Product("Pen", "Stationery", 50.0, 100)
    )

    // Apply 10% discount
    val discountedProducts = applyDiscount(products) { price ->
        price * 0.9
    }

    println("--- Discounted Product List ---")
    for (product in discountedProducts) {
        println("Name: ${product.name} | Category: ${product.category} | Price: ${product.price} | Stock: ${product.stock}")
    }

    // Filter products with stock less than 10
    val lowStockProducts = filterProducts(discountedProducts) { product ->
        product.stock < 10
    }

    println("\n--- Low Stock Products (<10) ---")
    for (product in lowStockProducts) {
        println("${product.name} (${product.stock})")
    }

    // Filter premium products with price greater than 1000
    val premiumProducts = filterProducts(discountedProducts) { product ->
        product.price > 1000
    }

    println("\n--- Premium Products (>1000) ---")
    for (product in premiumProducts) {
        println("${product.name} (${product.price})")
    }
}