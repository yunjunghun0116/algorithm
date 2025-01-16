import java.util.*
import kotlin.math.abs

private val rankList = ArrayList<Int>()
private fun main() {
    initialize()
    print(getMinDissatisfaction())
}

private fun initialize() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextLine().toInt()

    for (i in 1..n) {
        rankList.add(scanner.nextLine().toInt())
    }

    rankList.sort()
}

private fun getMinDissatisfaction(): Long {
    var result = 0L

    for (i in 1..rankList.size) {
        result += abs(i - rankList[i - 1])
    }

    return result
}

