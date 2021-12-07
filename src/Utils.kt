import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()
fun readInputAsInts(name: String) = File("src", "$name.txt").readLines().map { it.toInt() }

fun List<String>.toPair(): Pair<String, Int> {
    require (this.size == 2) { "List is not of length 2!" }
    val (a, b) = this
    return Pair(a, b.toInt())
}
fun readInputDay02(name: String) : List<Pair<String, Int>> = File("src", "$name.txt").readLines().map{ it.split(' ').toPair() }

fun readCommaSeparatedInputAsInt(name: String): List<Int> = File("src", "$name.txt").readText().split(',').map { it.toInt() }


/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
