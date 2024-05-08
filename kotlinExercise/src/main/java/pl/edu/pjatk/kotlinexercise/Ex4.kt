package pl.edu.pjatk.kotlinexercise

/**
 * Exercise 2: Protocol Support Check
 * You have a set of protocols supported by your server. A user requests to use a particular protocol.
 * Complete the program to check whether the requested protocol is supported or not.
 *
 * @hint Make sure that you check the requested protocol in upper case.
 * You can use the .uppercase() function to help you with this.
 */
fun main() {
    // Set of supported protocols
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")

    // The protocol requested by the user
    val requested = "smtp"

    // Check if the requested protocol (in upper case) is in the set of supported protocols
    val isSupported = requested.uppercase() in SUPPORTED

    // Print the support status for the requested protocol
    println("Support for $requested: $isSupported")
}
