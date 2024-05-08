package pl.edu.pjatk.kotlinexercise

/**
 * Exercise: Filtering Words Starting with 'l'
 * You have a list of words. Use a loop and an if statement to print only the words that start with the letter 'l'.
 *
 * This program prints only the words from the list that start with the letter "l".
 * It iterates through each word in the list and checks if it starts with "l".
 * If a word starts with "l", it is printed to the standard output.
 */
fun main() {
    // List of words
    val words = listOf("dinosaur", "limousine", "magazine", "language")

    // Iterate through each word in the list
    for (word in words) {
        // Check if the word starts with the letter "l"
        if (word.startsWith("l")) {
            // Print the word if it starts with "l"
            println(word)
        }
    }
}
