// Art Gallery Navigator

// Data class
data class Artwork(val title: String, val artist: String, val year: Int)

// Function to display artwork
fun displayArtwork(art: Artwork) {
    println("Viewing: ${art.title} (${art.artist}, ${art.year})")
}

// Function to move to next artwork
fun nextArtwork(currentIndex: Int, total: Int): Int {
    return if (currentIndex == total - 1) {
        0
    } else {
        currentIndex + 1
    }
}

// Function to move to previous artwork
fun previousArtwork(currentIndex: Int, total: Int): Int {
    return if (currentIndex == 0) {
        total - 1
    } else {
        currentIndex - 1
    }
}

// Main function
fun main() {

    val artworks = listOf(
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("The Persistence of Memory", "Salvador Dali", 1931),
        Artwork("The Scream", "Edvard Munch", 1893)
    )

    var currentIndex = 0

    // Show first artwork
    displayArtwork(artworks[currentIndex])

    // Simulate Next
    println("-> Next Artwork")
    currentIndex = nextArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])

    println("-> Next Artwork")
    currentIndex = nextArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])

    println("-> Next Artwork")
    currentIndex = nextArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])

    // Simulate Previous
    println("-> Previous Artwork")
    currentIndex = previousArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])
}