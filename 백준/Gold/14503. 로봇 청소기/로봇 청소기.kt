import java.io.IOException
import java.util.*

lateinit var room: Array<Array<Int>>
private fun main() {
    val cleaner = initialize()
    cleanRoom(cleaner)
}

private fun initialize(): Cleaner {
    val scanner = Scanner(System.`in`)
    val directionMap = mapOf(
        0 to Direction.TOP,
        1 to Direction.RIGHT,
        2 to Direction.BOTTOM,
        3 to Direction.LEFT,
    )
    val roomInput = scanner.nextLine().split(" ")
    room = Array(roomInput[0].toInt()) { Array(roomInput[1].toInt()) { 0 } }

    val cleanerInput = scanner.nextLine().split(" ")
    val direction = directionMap.get(cleanerInput[2].toInt()) ?: throw IOException()
    val cleaner = Cleaner(y = cleanerInput[0].toInt(), x = cleanerInput[1].toInt(), direction = direction)

    for (element in room) {
        val lineInput = scanner.nextLine().split(" ")
        for (j in 0..<room[0].size) {
            element[j] = lineInput[j].toInt()
        }
    }
    return cleaner
}

private fun cleanRoom(cleaner: Cleaner) {
    try {
        while (true) {
            if (room[cleaner.y][cleaner.x] == 0) {
                cleaner.clean()
            }
            if (!checkFourSide(cleaner.y, cleaner.x)) {
                if (cleaner.checkBack()) {
                    cleaner.moveBack()
                    continue
                }
            }
            cleaner.turn()
            if (cleaner.checkFront()) {
                cleaner.moveFront()
            }
        }
    } catch (exception: EndException) {
        print(cleaner.count)
    }
}

private fun checkFourSide(y: Int, x: Int): Boolean {
    val dy = listOf(0, 0, 1, -1)
    val dx = listOf(1, -1, 0, 0)
    for (i in 0..3) {
        val nextY = y + dy[i]
        val nextX = x + dx[i]
        if (room[nextY][nextX] == 0) return true
    }
    return false
}

private data class Cleaner(var y: Int, var x: Int, var direction: Direction) {
    var count = 0
        private set

    fun moveFront() {
        y += direction.dy()
        x += direction.dx()
    }

    fun moveBack() {
        y -= direction.dy()
        x -= direction.dx()
    }

    fun turn() {
        this.direction = direction.next()
    }

    fun checkFront(): Boolean {
        return room[y + direction.dy()][x + direction.dx()] == 0
    }

    fun checkBack(): Boolean {
        if (room[y - direction.dy()][x - direction.dx()] == 1) throw EndException()
        return true
    }

    fun clean() {
        if (room[y][x] == 0) {
            room[y][x] = -1
            count++
        }
    }
}

private enum class Direction {
    LEFT,
    RIGHT,
    TOP,
    BOTTOM;

    companion object {
        val nextDirectionMap = mapOf(
            LEFT to BOTTOM,
            BOTTOM to RIGHT,
            RIGHT to TOP,
            TOP to LEFT
        )
        val dyMap = mapOf(
            LEFT to 0,
            BOTTOM to 1,
            RIGHT to 0,
            TOP to -1
        )
        val dxMap = mapOf(
            LEFT to -1,
            BOTTOM to 0,
            RIGHT to 1,
            TOP to 0
        )
    }

    fun next(): Direction {
        return nextDirectionMap[this] ?: this
    }

    fun dy(): Int {
        return dyMap[this] ?: throw IOException()
    }

    fun dx(): Int {
        return dxMap[this] ?: throw IOException()
    }
}

private class EndException : RuntimeException()