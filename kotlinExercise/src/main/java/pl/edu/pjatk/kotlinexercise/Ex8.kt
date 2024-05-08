package pl.edu.pjatk.kotlinexercise

/**
 *
 * Exercise: FizzBuzz
 * Use a for loop to count numbers from 1 to 100 and a when expression to decide what to print at each step.
 * If the number is divisible by both 3 and 5, print "fizzbuzz".
 * If the number is divisible by 3, print "fizz".
 * If the number is divisible by 5, print "buzz".
 * Otherwise, print the number itself.
 *
 * This program simulates the Fizz buzz game.
 * It prints numbers from 1 to 100, replacing any number divisible by three with "fizz",
 * any number divisible by five with "buzz", and any number divisible by both three and five with "fizzbuzz".
 */
fun main() {
    // Iterate through numbers from 1 to 100
    for (number in 1..100) {
        println(
            when {
                // If the number is divisible by both 3 and 5, print "fizzbuzz"
                number % 15 == 0 -> "fizzbuzz"
                // If the number is divisible by 3, print "fizz"
                number % 3 == 0 -> "fizz"
                // If the number is divisible by 5, print "buzz"
                number % 5 == 0 -> "buzz"
                // Otherwise, print the number itself
                else -> number.toString()
            }
        )
    }
}
