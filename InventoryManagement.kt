// Session 9 Lab
// Inventory Management System
// MindMatrix Compatible Version (ASCII Safe)

data class InventoryItem<T>(
    val id: T,
    val name: String,
    val category: String,
    val price: Double,
    val stock: Int
)

fun main() {

    println("===== Inventory Management System =====")

    val inventory = listOf(
        InventoryItem(1, "Laptop", "Electronics", 50000.0, 10),
        InventoryItem(2, "Mouse", "Electronics", 800.0, 0),
        InventoryItem(3, "Notebook", "Stationery", 50.0, 100),
        InventoryItem(4, "Pen", "Stationery", 20.0, 200),
        InventoryItem(5, "Chair", "Furniture", 1500.0, 5)
    )

    // Filter items in stock
    val inStockItems = inventory.filter { it.stock > 0 }

    println("\nItems In Stock:")
    for (item in inStockItems) {
        println("${item.name} - Stock: ${item.stock}")
    }

    // Filter by category
    val electronics = inventory.filter { it.category == "Electronics" }

    println("\nElectronics Items:")
    for (item in electronics) {
        println("${item.name} - Price: ${item.price}")
    }

    // Compute total stock value per category
    val grouped = inventory.groupBy { it.category }

    println("\nCategory Total Stock Value:")

    for ((category, items) in grouped) {

        val total = items
            .map { it.price * it.stock }
            .sum()

        println("$category - Rs %.2f".format(total))
    }

    // Total inventory value
    val totalInventoryValue = inventory
        .map { it.price * it.stock }
        .sum()

    println("\nTotal Inventory Value: Rs %.2f".format(totalInventoryValue))
}