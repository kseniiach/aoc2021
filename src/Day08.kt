fun main() {
    fun part1(input: List<String>): Int {
        val output_values = input.map { getOutputValues(it) } .flatten()
        val output_values_len : List<Int> = output_values.map { it -> it.length }
        return output_values_len.count{it -> it == 2 || it == 3 || it == 4 || it == 7}
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Input/Day08_test")
    //println(testInput)
    check(part1(testInput) == 26)
    //part1(testInput)

    val input = readInput("Input/Day08")
    println(part1(input))
    //println(part2(input))
}

private fun getOutputValues(input : String) : List<String>  {
    return input.dropWhile { it != '|' }. // drop all symbols before the | delimiter
    drop(2). // drop the delimiter and the whitespace after delimiter
    split( ' ') // split into separate words
}
