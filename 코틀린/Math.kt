import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Scanner
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.random.Random

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    // 상수 처리
    val i = 10
    val j = 20
    print(max(i,j))

    // 랜덤 값 추출
    val randomNum = Random.nextInt(0, 100) // 0~99

    // 입력 방식
    // 1. 스캐너
    // val reader = Scanner(System.`in`)
    // reader.nextInt()
    // reader.nextLine()
    // 2. with 를 사용한 입력 받기
    val token = StringTokenizer(readLine())
    print(Integer.parseInt(token.nextToken())+Integer.parseInt(token.nextToken()))
}
