fun main() {

    fun part1(input: List<Pair<String, Int>>): Int {
        var depth: Int = 0
        var horizontal_position: Int = 0
        var aim: Int = 0

        for ((direction, x) in input){
            when (direction){
                "forward" -> horizontal_position += x
                "down" -> depth += x
                "up" -> depth -= x
            }
        }

        return depth * horizontal_position
    }

    fun part2(input: List<Pair<String, Int>>): Int {
        var depth: Int = 0
        var horizontal_position: Int = 0
        var aim: Int = 0

        for ((direction, x) in input){
            when (direction){
                "forward" -> horizontal_position += x
                "down" -> depth += x
                "up" -> depth -= x
            }
        }

        return depth * horizontal_position
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputDay02("Input/Day02_test")
    check(part1(testInput) == 150)
    //check(part2(testInput) == 900)

    val input = readInputDay02("Input/Day02")
    println("Problem 1 answer is: " + part1(input))
    //println("Problem 2 answer is: " + part2(input))
}
