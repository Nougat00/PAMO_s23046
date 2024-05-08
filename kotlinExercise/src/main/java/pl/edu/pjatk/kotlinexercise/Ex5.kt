package pl.edu.pjatk.kotlinexercise

/**
 * Exercise: Spelling Numbers
 * Define a map that relates integer numbers from 1 to 3 to their corresponding spelling.
 * Use this map to spell the given number.
 */
fun main() {
    // Map relating integer numbers to their corresponding spelling
    val number2word = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )

    // The number to be spelled
    val n = 2

    // Print the number and its corresponding spelling
    println("$n is spelt as '${number2word[n]}'")
}
