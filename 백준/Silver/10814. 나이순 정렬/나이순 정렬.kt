import java.util.*

data class Person(val age: Int, val count: Int, val name: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        if (this.age == other.age) {
            return this.count - other.count
        }
        return this.age - other.age
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().toInt()

    val pq = PriorityQueue<Person>()

    for (i in 1..n) {
        val input = scanner.nextLine()
        val personInfo = input.split(" ")
        pq.add(
            Person(
                name = personInfo[1],
                age = personInfo[0].toInt(),
                count = i,
            )
        )
    }

    while (pq.isNotEmpty()) {
        val person = pq.poll()
        println("${person.age} ${person.name}")
    }
}