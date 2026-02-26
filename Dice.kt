// Session 6 Lab
// Dice Rolling Simulator
// MindMatrix Internship

import kotlin.random.Random

// Function to roll a single die
fun rollDie(): Int {
    return Random.nextInt(1, 7) // Generates number between 1 and 6
}

// Function to roll two dice and print result
fun rollDicePair() {

    val die1 = rollDie()
    val die2 = rollDie()

    println("Rolling the dice...")
    println("Die 1: $die1")
    println("Die 2: $die2")

    val total = die1 + die2
    println("Total: $total")

    // Check for doubles
    if (die1 == die2) {
        println("Wow! You rolled doubles! Lucky roll!")
    }
}

fun main() {

    println("===== Dice Rolling Simulator =====")

    while (true) {

        println("\nPress Enter to roll the dice or type 'exit' to quit:")
        val input = readLine()

        if (input.equals("exit", ignoreCase = true)) {
            println("Thanks for playing!")
            break
        }

        rollDicePair()
    }
}