import kotlin.math.ceil

fun calculateTip(amount: Double, tipPercent: Double, roundUp: Boolean): Double {
    val tip = amount * tipPercent / 100
    return if (roundUp) ceil(tip) else tip
}

fun main() {

    println("===== Tip Calculator =====")

    print("Enter bill amount: ")
    val amountInput = readLine()

    if (amountInput.isNullOrBlank()) {
        println("Invalid bill amount.")
        return
    }

    val amount = amountInput.toDoubleOrNull()
    if (amount == null || amount <= 0) {
        println("Invalid bill amount.")
        return
    }

    print("Enter tip percentage (e.g., 10 for 10%): ")
    val tipInput = readLine()

    if (tipInput.isNullOrBlank()) {
        println("Invalid tip percentage.")
        return
    }

    val tipPercent = tipInput.toDoubleOrNull()
    if (tipPercent == null || tipPercent < 0) {
        println("Invalid tip percentage.")
        return
    }

    print("Round up tip? (yes/no): ")
    val roundInput = readLine()
    val roundUp = roundInput.equals("yes", ignoreCase = true)

    val tipAmount = calculateTip(amount, tipPercent, roundUp)
    val totalAmount = amount + tipAmount

    println("\nTip Amount: %.2f".format(tipAmount))
    println("Total Bill: %.2f".format(totalAmount))
}