// Data class
data class Profile(val name: String, val title: String, val bio: String)


// Creates a simple ASCII avatar placeholder
fun renderAvatar(width: Int, height: Int): String {
    val result = StringBuilder()

    for (i in 0 until height) {
        val lineContent = if (i == height / 2) {
            val text = "Avatar"
            val paddingLeft = (width - text.length) / 2
            val paddingRight = width - text.length - paddingLeft
            " ".repeat(paddingLeft) + text + " ".repeat(paddingRight)
        } else {
            " ".repeat(width)
        }

        result.append("| $lineContent |\n")
    }

    return result.toString()
}


// Renders a labeled text line trimmed to width
fun renderTextBlock(label: String, text: String, width: Int): String {
    val content = "$label: $text"
    val trimmed = if (content.length > width) {
        content.take(width)
    } else {
        content
    }

    val padding = width - trimmed.length
    return "| $trimmed${" ".repeat(padding)} |\n"
}


// Builds the complete profile card
fun renderProfile(profile: Profile, width: Int = 30, showAvatar: Boolean = true): String {
    val border = "+${"-".repeat(width + 2)}+\n"
    val result = StringBuilder()

    result.append(border)

    if (showAvatar) {
        result.append(renderAvatar(width, 3))
    }

    result.append(renderTextBlock("Name", profile.name, width))
    result.append(renderTextBlock("Title", profile.title, width))
    result.append(renderTextBlock("Bio", profile.bio, width))

    result.append(border)

    return result.toString()
}


// Main function
fun main() {

    val profile1 = Profile(
        "Ada Lovelace",
        "Software Dev",
        "Early computing pioneer"
    )

    val profile2 = Profile(
        "Alan Turing",
        "Mathematician",
        "Father of computer science"
    )

    val profile3 = Profile(
        "Grace Hopper",
        "Computer Scientist",
        "COBOL creator"
    )

    println(renderProfile(profile1, 30, true))
    println(renderProfile(profile2, 30, false))
    println(renderProfile(profile3, 30, true))
}