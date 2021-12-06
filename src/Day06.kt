import java.io.File

fun readCommaSeparatedInputAsInt(name: String): List<Int> = File("src", "$name.txt").readText().split(',').map { it.toInt() }

fun main() {

    // really slow !
    fun part1(input: List<Int>): Int {
        var output = input
        var counter: Int

        for (i in 0 until 80) {
            counter = output.count { it == 0 }
            output = output.map { it -> if (it == 0) 6 else it - 1}
            for (j in 0 until counter)
                output += 8
            //println(output[0])
        }

        return output.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput =  readCommaSeparatedInputAsInt("Input/Day06_test")
    val input =  readCommaSeparatedInputAsInt("Input/Day06")
    println(testInput)
    println(part1(testInput))
    //println(part1(input))
    //check(part1(testInput) == 1)
}
