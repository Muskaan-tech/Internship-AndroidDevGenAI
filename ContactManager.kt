// Session 5 Lab
// Console-Based Contact Manager
// MindMatrix Internship

// 1️⃣ Data Class
data class Contact(
    val name: String,
    val phone: String,
    val email: String?,      // Nullable email
    val isFavorite: Boolean
)

fun main() {

    val contacts = mutableListOf<Contact>()

    loop@ while (true) {

        println("\n===== Contact Manager =====")
        println("1. Add Contact")
        println("2. View All Contacts")
        println("3. View Favorite Contacts")
        println("4. View Contacts With Email")
        println("5. Exit")
        print("Enter your choice: ")

        when (readLine()?.toIntOrNull()) {

            1 -> addContact(contacts)

            2 -> viewContacts(contacts)

            3 -> filterContacts(contacts) { it.isFavorite }

            4 -> filterContacts(contacts) { it.email != null }

            5 -> {
                println("Exiting Contact Manager...")
                break@loop   // Fixed break issue
            }

            else -> println("Invalid choice. Please try again.")
        }
    }
}

// 2️⃣ Add Contact Function
fun addContact(contacts: MutableList<Contact>) {

    print("Enter Name: ")
    val name = readLine() ?: "Unknown"

    print("Enter Phone: ")
    val phone = readLine() ?: "Not Provided"

    print("Enter Email (optional): ")
    val emailInput = readLine()
    val email = if (emailInput.isNullOrBlank()) null else emailInput

    print("Is Favorite? (yes/no): ")
    val favoriteInput = readLine()
    val isFavorite = favoriteInput.equals("yes", ignoreCase = true)

    val contact = Contact(name, phone, email, isFavorite)
    contacts.add(contact)

    println("Contact added successfully!")
}

// 3️⃣ View All Contacts
fun viewContacts(contacts: List<Contact>) {

    if (contacts.isEmpty()) {
        println("No contacts available.")
        return
    }

    println("\n--- All Contacts ---")

    for ((index, contact) in contacts.withIndex()) {
        println("${index + 1}. Name: ${contact.name}")
        println("   Phone: ${contact.phone}")
        println("   Email: ${contact.email ?: "No Email"}")
        println("   Favorite: ${if (contact.isFavorite) "Yes" else "No"}")
    }
}

// 4️⃣ Higher-Order Function for Filtering
fun filterContacts(
    contacts: List<Contact>,
    filterCondition: (Contact) -> Boolean
) {

    val filteredList = contacts.filter(filterCondition)

    if (filteredList.isEmpty()) {
        println("No matching contacts found.")
        return
    }

    println("\n--- Filtered Contacts ---")

    for (contact in filteredList) {
        println("Name: ${contact.name}")
        println("Phone: ${contact.phone}")
        println("Email: ${contact.email ?: "No Email"}")
        println("Favorite: ${if (contact.isFavorite) "Yes" else "No"}")
        println()
    }
}