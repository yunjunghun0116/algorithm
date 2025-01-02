import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = Integer.parseInt(scanner.nextLine())

    if (n % 2 == 0) {
        print("CY")
    } else {
        print("SK")
    }
}
