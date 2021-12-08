import kotlin.math.ceil
import kotlin.math.floor

fun main() {
    fun part1(input: List<Int>): Int {
        val sum = input.sum()
        val len = input.size

        val exact = sum.toDouble() / len
        val floor = floor(exact)
        val ceiling = ceil(exact)

        val best_value: Int = if ((exact - floor) < (ceiling - exact)) floor.toInt() else ceiling.toInt()

        return best_value
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readCommaSeparatedInputAsInt("Input/Day07_test")
    println(testInput)
    println(part1(testInput))
    //check(part1(testInput) == 1)

    //val input = readInput("Input/Day01")
    //println(part1(input))
    //println(part2(input))
}
