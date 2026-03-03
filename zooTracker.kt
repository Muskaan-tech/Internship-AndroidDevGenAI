// Zoo Animal Tracker

// 1️⃣ Abstract class
abstract class Animal(val name: String) {
    abstract fun makeSound()
}

// 3️⃣ Interface
interface Feedable {
    fun feed(food: String)
}

// 2️⃣ Subclasses

class Lion(name: String) : Animal(name), Feedable {

    override fun makeSound() {
        println("$name: Roar!")
    }

    fun hunt() {
        println("$name is hunting in the jungle.")
    }

    override fun feed(food: String) {
        println("$name eats $food.")
    }
}

class Elephant(name: String) : Animal(name) {

    override fun makeSound() {
        println("$name: Trumpet!")
    }

    fun sprayWater() {
        println("$name sprays water from its trunk.")
    }
}

class Parrot(name: String) : Animal(name), Feedable {

    override fun makeSound() {
        println("$name: Chirp!")
    }

    fun fly() {
        println("$name is flying around.")
    }

    override fun feed(food: String) {
        println("$name pecks at $food.")
    }
}

// 4️⃣ Function to display zoo animals
fun displayZoo(animals: List<Animal>) {
    println("--- Zoo Tracker ---")
    for (animal in animals) {
        animal.makeSound()
    }
}

// 5️⃣ Main function
fun main() {

    val lion = Lion("Leo")
    val elephant = Elephant("Ella")
    val parrot = Parrot("Polly")

    val zooAnimals: List<Animal> = listOf(lion, elephant, parrot)

    // Polymorphism in action
    displayZoo(zooAnimals)

    // Feeding animals that implement Feedable
    lion.feed("meat")
    parrot.feed("seeds")

    // Calling subclass-specific behaviors
    elephant.sprayWater()
    lion.hunt()
    parrot.fly()
}