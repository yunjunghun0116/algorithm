import java.util.*
import kotlin.math.max

private val safeAreaList = ArrayList<Int>()
private val combinationList = ArrayList<Int>()
private lateinit var matrix: Array<Array<Int>>
private var n = 0
private var m = 0
private var maxArea = 0

private fun main() {
    initialize()
    setCombination(0)
    println(maxArea)
}

//초기 데이터 생성
private fun initialize() {
    val scanner = Scanner(System.`in`)
    val sizeInput = scanner.nextLine().split(" ")

    n = sizeInput[0].toInt()
    m = sizeInput[1].toInt()
    matrix = Array(n) { Array(m) { 0 } }

    for (i in 0..<n) {
        val rowInput = scanner.nextLine().split(" ")
        for (j in 0..<m) {
            matrix[i][j] = rowInput[j].toInt()
            if (matrix[i][j] == 0) {
                safeAreaList.add(i * m + j)
            }
        }
    }
}

//조합을 통해 어떤 위치에 벽을 세울건지 벽 3개 고르기
private fun setCombination(currIndex: Int) {
    if (combinationList.size == 3) {
        val copiedMatrix = copyMatrix()
        virusBFS(copiedMatrix)
        return
    }
    if (currIndex == safeAreaList.size) return
    for (i in currIndex..<safeAreaList.size) {
        combinationList.add(safeAreaList[i])
        setCombination(i + 1)
        combinationList.removeAt(combinationList.size - 1)
    }
}

private fun copyMatrix(): Array<Array<Int>> {
    val copiedMatrix = Array(matrix.size) { i ->
        matrix[i].clone()
    }
    for (number in combinationList) {
        val y = number / m
        val x = number % m
        copiedMatrix[y][x] = 1
    }
    return copiedMatrix
}

//바이러스 퍼져나가는 작업 처리
private fun virusBFS(copiedMatrix: Array<Array<Int>>) {
    val visited = Array(n) { Array(m) { false } }
    val queue = LinkedList<Array<Int>>()
    val dy = listOf(0, 0, 1, -1)
    val dx = listOf(1, -1, 0, 0)

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (copiedMatrix[i][j] == 2) {
                //bfs 시작, 여기를 기준 주변이 0일경우 2로 변경
                queue.add(arrayOf(i, j))

                while (queue.isNotEmpty()) {
                    val pos = queue.poll()
                    if (visited[pos[0]][pos[1]]) continue
                    visited[pos[0]][pos[1]] = true

                    for (k in 0..3) {
                        val nextY = pos[0] + dy[k]
                        val nextX = pos[1] + dx[k]
                        if (nextY < 0 || nextY >= copiedMatrix.size || nextX < 0 || nextX >= copiedMatrix[0].size) continue
                        if (copiedMatrix[nextY][nextX] != 0) continue
                        copiedMatrix[nextY][nextX] = 2
                        queue.add(arrayOf(nextY, nextX))
                    }
                }
            }
        }
    }

    val areaSize = areaCheck(copiedMatrix)
    maxArea = max(maxArea, areaSize)
}

// 여기서 안전영역 크기 반환
private fun areaCheck(copiedMatrix: Array<Array<Int>>): Int {
    var count = 0
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (copiedMatrix[i][j] == 0) {
                count++
            }
        }
    }
    return count
}
