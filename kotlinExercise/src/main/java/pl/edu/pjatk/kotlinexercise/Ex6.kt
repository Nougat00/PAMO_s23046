package pl.edu.pjatk.kotlinexercise

/**
 * Exercise: GameBoy Button Actions
 * Using a when expression, update the following program so that when you input the names of GameBoy buttons,
 * the actions are printed to output.
 *
 * Button   Action
 * A        Yes
 * B        No
 * X        Menu
 * Y        Nothing
 * Other    There is no such button
 *
 * The following examples use the increment operator ++ to increment the value of the cakesEaten variable.
 */
fun main() {
    // The button pressed by the user
    val button = "A"

    // Print the action corresponding to the button
    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}
