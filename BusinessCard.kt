// 1) Data class
data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String
)


// Utility function to center text inside a given width
fun centerText(text: String, width: Int): String {
    val trimmed = if (text.length > width) text.take(width) else text
    val paddingLeft = (width - trimmed.length) / 2
    val paddingRight = width - trimmed.length - paddingLeft
    return " ".repeat(paddingLeft) + trimmed + " ".repeat(paddingRight)
}


// 2) Print Logo
fun printLogo(width: Int) {
    val logo = "[ANDROID]"
    println("|${centerText(logo, width)}|")
}


// 3) Print Header (Name + Title)
fun printHeader(card: BusinessCard, width: Int) {
    println("|${centerText(card.name, width)}|")
    println("|${centerText(card.title, width)}|")
}


// 4) Print Contacts (optional)
fun printContacts(card: BusinessCard, width: Int, showContacts: Boolean) {
    if (!showContacts) return

    val phoneLine = "Phone: ${card.phone}"
    val emailLine = "Email: ${card.email}"

    println("| ${phoneLine.padEnd(width - 1)}|")
    println("| ${emailLine.padEnd(width - 1)}|")
}


// 5) Main function
fun main() {

    val width = 50

    val card = BusinessCard(
        name = "Aditya Deshpande",
        title = "Android Developer",
        phone = "+91-98765-43210",
        email = "aditya@example.com"
    )

    val border = "-".repeat(width + 2)

    println(border)
    printLogo(width)
    println("|${" ".repeat(width)}|")
    printHeader(card, width)
    println("|${" ".repeat(width)}|")
    printContacts(card, width, showContacts = true)
    println(border)
}