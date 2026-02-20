fun main() {

    println("========== Kotlin Kickstart: Session Progress Report ==========\n")

    // PART 1
    val userName = "Muskaan"
    println("Hello, I'm $userName, and this is my Kotlin learning report for today.\n")

    // PART 2
    val initialScore = 10
    var currentScore = 10
    currentScore += 15
    println("My initial goal score was $initialScore, but now I've reached $currentScore points!\n")

    // PART 3
    val totalProgress = calculateProgress(30, 20)
    println("In total, I've earned $totalProgress learning points today.\n")

    // PART 4
    val topics = mutableListOf("Variables", "Functions", "Strings")
    topics.add("Collections")
    topics.removeAt(2)

    val topicSummary = summarizeTopics(topics)
    println("Today, I explored the following topics: $topicSummary\n")

    // PART 5
    encourageUser(userName, topics)

    println("\n========== End of My Kotlin Learning Report ==========")
}

fun calculateProgress(base: Int, bonus: Int): Int {
    return base + bonus
}

fun summarizeTopics(topics: List<String>): String {
    return topics.joinToString(", ")
}

fun encourageUser(name: String, topics: List<String>) {
    println("I'm proud of myself! I, $name, completed ${topics.size} topics in this session.")
}