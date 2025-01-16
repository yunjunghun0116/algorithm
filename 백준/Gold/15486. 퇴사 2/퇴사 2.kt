import java.util.*
import kotlin.math.max

lateinit var dp: Array<Array<Int>>
private fun main() {
    initialize()
    val result = findMaxPrice()
    println(result)
}

private fun initialize() {
    val scanner = Scanner(System.`in`)
    val dpSize = scanner.nextLine().toInt()
    dp = Array(dpSize) { Array(3) { 0 } }

    for (i in 0..<dpSize) {
        val dayInput = scanner.nextLine().split(" ")
        dp[i][0] = dayInput[0].toInt()
        dp[i][1] = dayInput[1].toInt()
    }
}

private fun findMaxPrice(): Int {
    for (i in dp.size - 1 downTo 0) {
        if (i == dp.size - 1) {
            dp[i][2] = if (dp[i][0] == 1) dp[i][1] else 0
            continue
        }
        if (i + dp[i][0] == dp.size) {
            dp[i][2] = max(dp[i][1], dp[i + 1][2])
            continue
        }
        if (i + dp[i][0] > dp.size) {
            dp[i][2] = dp[i + 1][2]
            continue
        }
        dp[i][2] = max(dp[i + dp[i][0]][2] + dp[i][1], dp[i + 1][2])
    }
    return dp[0][2]
}