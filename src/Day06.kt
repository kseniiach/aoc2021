import java.io.File

fun readCommaSeparatedInputAsInt(name: String): List<Int> = File("src", "$name.txt").readText().split(',').map { it.toInt() }

fun main() {


    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput =  readCommaSeparatedInputAsInt("Input/Day06_test")
    println(testInput)
    //check(part1(testInput) == 1)

    val input = readInput("Input/Day02")
    println(part1(input))
    println(part2(input))
}
