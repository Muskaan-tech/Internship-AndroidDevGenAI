data class Theme(
    val name: String,
    val foregroundSymbol: String,
    val backgroundSymbol: String
)

fun printHeader(title: String) {
    println("===================================")
    println("         $title")
    println("===================================")
}

fun applyTheme(theme: Theme) {
    println("\nApplying Theme: ${theme.name}")
    println("Foreground Symbol: ${theme.foregroundSymbol}")
    println("Background Symbol: ${theme.backgroundSymbol}")
}

fun animateProgressBar(theme: Theme) {
    println("\nLoading with ${theme.name} Theme...\n")

    val totalSteps = 20

    for (i in 1..totalSteps) {

        val progress = theme.foregroundSymbol.repeat(i)
        val remaining = theme.backgroundSymbol.repeat(totalSteps - i)

        print("\r[$progress$remaining] ${i * 5}%")
        Thread.sleep(100)
    }

    println("\n\nLoading Complete!")
}

fun main() {

    printHeader("Console Theme Switcher")

    val lightTheme = Theme("Light", "#", "-")
    val darkTheme = Theme("Dark", "*", ".")
    val blueTheme = Theme("Blue", "=", "~")

    val themes = listOf(lightTheme, darkTheme, blueTheme)

    println("Available Themes:")
    for ((index, theme) in themes.withIndex()) {
        println("${index + 1}. ${theme.name}")
    }

    print("\nSelect a theme (1-3): ")
    val choiceInput = readLine()
    val choice = choiceInput?.toIntOrNull()

    if (choice == null || choice !in 1..3) {
        println("Invalid selection. Defaulting to Light Theme.")
        applyTheme(lightTheme)
        animateProgressBar(lightTheme)
    } else {
        val selectedTheme = themes[choice - 1]
        applyTheme(selectedTheme)
        animateProgressBar(selectedTheme)
    }

    println("\nProgram Finished Successfully.")
}