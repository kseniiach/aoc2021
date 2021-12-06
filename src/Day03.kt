fun String.binStringToInt(): Int {
    val len = this.length
    var res = 0
    var power_of_2 = 1
    for (i in len-1 downTo  0) {
        if (this[i] == '1') res += power_of_2
        power_of_2 *= 2
    }
    return res
}

fun main() {
    fun part1(input: List<String>): Int {
        val intInput = input.map{it.binStringToInt()}
        val numlen = input[1].length

        val powers_of_2 = mutableListOf<Int>()
        var power = 1
        for (i in 0 until numlen) { // length of the numbers
            powers_of_2.add(power)
            power *= 2
        }

        var epsilon_rate = 0
        var zeroes_count: Int
        var ones_count: Int
        for (mask in powers_of_2){
            zeroes_count = 0
            ones_count = 0
            for (line in intInput)
                if (mask.and(line) != 0) ones_count++ else zeroes_count++

            if (ones_count > zeroes_count) epsilon_rate += mask
        }

        val gamma_rate: Int = epsilon_rate.xor(power-1) // flips all bits
        return epsilon_rate * gamma_rate
    }

    fun part2(input: List<String>): Int {
        var intInput = input.map{it.binStringToInt()}
        val numlen = input[1].length
        var intInput1 = intInput
        var intInput2 = intInput

        val powers_of_2 = mutableListOf<Int>()
        var power = 1
        for (i in 0 until numlen) { // length of the numbers
            powers_of_2.add(power)
            power *= 2
        }

        var oxygen_generator_rating = 0
        var CO2_scrubber_rating = 0

        var zeroes_count: Int
        var ones_count: Int
        for (mask in powers_of_2.asReversed()){
            zeroes_count = 0
            ones_count = 0
            for (line in intInput1)
                if (mask.and(line) != 0) ones_count++ else zeroes_count++

            if (ones_count > zeroes_count) {
                intInput1 = intInput1.filter { it.and(mask) != 0 }
                intInput2 = intInput2.filter { it.and(mask) == 0 }
            }
            else if (ones_count == zeroes_count) {
                intInput1 = intInput1.filter { it.and(mask) != 0 }
                intInput2 = intInput2.filter { it.and(mask) == 0 }
            }
            else {
                intInput1 = intInput1.filter { it.and(mask) == 0 }
                intInput2 = intInput2.filter { it.and(mask) != 0 }
            }

            if (intInput1.size == 1) {
                oxygen_generator_rating = intInput1[0]
            }
            if (intInput2.size == 1) {
                CO2_scrubber_rating = intInput2[0]
            }
        }

        return oxygen_generator_rating * CO2_scrubber_rating
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Input/Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Input/Day03")
    check(part1(input) == 1071734)
    println(part2(input))
}
