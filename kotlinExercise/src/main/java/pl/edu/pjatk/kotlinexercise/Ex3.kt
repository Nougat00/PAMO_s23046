package pl.edu.pjatk.kotlinexercise

/**
 * Exercise: Counting Total Numbers
 * You have a list of "green" numbers and a list of "red" numbers.
 * Complete the code to print how many numbers there are in total.
 */
fun main() {
    // List of "green" numbers
    val greenNumbers = listOf(1, 4, 23)
    // List of "red" numbers
    val redNumbers = listOf(17, 2)

    // Calculate the total count of numbers by adding the counts of numbers in the green and red lists
    val totalCount = greenNumbers.count() + redNumbers.count()

    // Print the total count of numbers
    println(totalCount)
}
