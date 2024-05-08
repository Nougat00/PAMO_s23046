package pl.edu.pjatk.kotlinexercise

/**
 * Exercise: Pizza Slice Counting
 * You have a program that counts pizza slices until there's a whole pizza with 8 slices.
 * Refactor this program in two ways:
 * 1. Use a while loop.
 * 2. Use a do-while loop.
 */
fun main() {
    // Pizza slice counter
    var pizzaSlices = 0

    // Refactor using a while loop
    while (pizzaSlices < 7) {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    pizzaSlices++
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")

    // Reset pizza slice counter
    pizzaSlices = 0

    // Refactor using a do-while loop
    pizzaSlices++
    do {
        println("There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    } while (pizzaSlices < 8)
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}