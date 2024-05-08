package pl.edu.pjatk.kotlinexercise

/**
 * Exercise: Circle Area Calculation
 * Write a function called circleArea that takes the radius of a circle in integer format as a parameter
 * and outputs the area of that circle.
 *
 * @param radius The radius of the circle.
 * @return The area of the circle.
 */
import kotlin.math.PI

fun circleArea(radius: Int): Double {
    // Calculate the area of the circle using the formula: π * r^2
    return PI * radius * radius
}

fun main() {
    println(circleArea(2)) // Output: 12.566370614359172
}
