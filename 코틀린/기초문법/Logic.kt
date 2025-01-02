package 기초문법

import kotlin.random.Random

fun main() {
    var i = Random.nextInt(0, 15)
    // if문
    if (i > 10) {
        print("10보다 크다")
    } else if (i > 5) {
        print("5보다 크다")
    } else {
        print("5보다 작거나 같다")
    }
    // if문 -> when 문
    when {
        i > 10 -> {
            print("10보다 크다")
        }

        i > 5 -> {
            print("5보다 크다")
        }

        else -> {
            print("5보다 작거나 같다")
        }
    }
    // if식, when 으로도 가능
    var result = if (i > 10) {
        "10보다 크다"
    } else if (i > 5) {
        "5보다 크다"
    } else {
        "5보다 작거나 같다"
    }

    var boolValue = if (i > 10) true else false

    // for문 처리
    val items = listOf(1, 2, 3, 4, 5)

    for (item in items) {
        print(item)
    }

    for (i in 0..items.size - 1) {
        print(items[i])
    }
}
