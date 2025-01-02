import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextLine().toInt()
    for (i in 0..n - 1) {
        case()
    }
}

fun case() {
    val array = makeArray()
    val cnt = find(array)
    println(cnt)
}

fun makeArray(): Array<Array<Int>> {
    val caseInfo = sc.nextLine().split(" ")
    val m = caseInfo[0].toInt()
    val n = caseInfo[1].toInt()
    val k = caseInfo[2].toInt()

    val array = Array(m) { Array(n) { 0 } }

    for (i in 1..k) {
        val pos = sc.nextLine().split(" ")
        val x = pos[0].toInt()
        val y = pos[1].toInt()
        array[x][y] = 1
    }

    return array
}

fun find(array: Array<Array<Int>>): Int {
    val m = array.size
    val n = array[0].size
    val queue: Queue<Array<Int>> = LinkedList<Array<Int>>()
    val visited = Array(m) { Array(n) { false } }

    var cnt = 0

    for (i in 0..m - 1) {
        for (j in 0..n - 1) {
            if (array[i][j] == 1 && !visited[i][j]) {
                queue.add(arrayOf(i, j))
                bfs(array, queue, visited)
                cnt++
            }
        }
    }

    return cnt
}

fun bfs(array: Array<Array<Int>>, queue: Queue<Array<Int>>, visited: Array<Array<Boolean>>) {
    val dy = arrayOf(0, 0, 1, -1)
    val dx = arrayOf(1, -1, 0, 0)
    val m = array.size
    val n = array[0].size
    while (queue.isNotEmpty()) {
        val item = queue.poll()
        if (visited[item[0]][item[1]]) continue
        visited[item[0]][item[1]] = true
        for (i in 0..3) {
            val nextX = item[0] + dx[i]
            val nextY = item[1] + dy[i]
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue
            if (array[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                queue.add(arrayOf(nextX, nextY))
            }
        }
    }
}
