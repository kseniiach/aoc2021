fun main() {
    fun part1(input: List<String>): Int {
        var depth: Int = 0
        var horizontal_position: Int = 0

        var direction: String = ""
        var x: Int = 0
        var tuple: List<String>

        for (line in input){

            tuple = line.split(' ')
            direction = tuple[0]
            x = tuple[1].toInt()

            when (direction){
                "forward" -> horizontal_position += x
                "down" -> depth += x
                "up" -> depth -= x
            }
        }

        return depth * horizontal_position
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Input/Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Input/Day02")
    println("Problem 1 answer is: " + part1(input))
    println("Problem 2 answer is: " + part2(input))
}
