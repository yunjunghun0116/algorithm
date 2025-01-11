import java.util.*

val itemList = ArrayList<Item>()
val itemPriorityQueue = PriorityQueue<Item>()
val bagList = ArrayList<Int>()

fun main() {
    initialize()
    val result = calculation()
    println(result)
}

fun initialize() {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().split(" ")
    val n = input[0].toInt()
    val k = input[1].toInt()

    for (i in 1..n) {
        val itemInfo = scanner.nextLine().split(" ")
        val item = Item(
            weight = itemInfo[0].toInt(),
            value = itemInfo[1].toInt()
        )
        itemList.add(item)
    }

    for (i in 1..k) {
        bagList.add(scanner.nextLine().toInt())
    }

    itemList.sortWith { a, b -> a.weight - b.weight }
    bagList.sort()
}

fun calculation(): Long {
    if (itemList.isEmpty() || bagList.isEmpty()) return 0
    var result = 0L
    var idx = 0
    for (bag in bagList) {
        while (idx < itemList.size && itemList[idx].weight <= bag) {
            itemPriorityQueue.add(itemList[idx])
            idx++
        }
        result += pollQueue()
    }

    return result
}

fun pollQueue(): Int {
    if (itemPriorityQueue.isEmpty()) return 0
    return itemPriorityQueue.poll().value
}

data class Item(val weight: Int, val value: Int) : Comparable<Item> {
    override fun compareTo(other: Item): Int {
        return other.value - this.value
    }
}