package 기초문법

fun main() {
    val dog: Animal = Dog("강아지")
    val cat: Cat = Cat("고양이")

    if (dog is Dog) {
        dog.move()
        println("얘는 강아지")
    }

    if (cat is Animal) {
        println("동물은 확실하네")
    }

    cat.move()
    val animal = cat as Animal
    animal.move()

    val box = Box(10)
    val boxStr = Box("String")

}

// 기본적으로는 추상클래스만 상속이 가능
// 일반 클래스를 상속하려면 open class ~~ 를 해주어야 한다
abstract class Animal(val name: String) {
    // 자식에게 열어줄 함수
    open fun move() {
        println("이동")
    }
}

// 상속을 받아도 기본적으로는 override 가 안된다.
class Dog(name: String) : Animal(name), Drawable {
    override fun move() {
        println("껑충")
    }

    override fun draw() {
        println("그림 그리기 with 강아지")
    }
}

class Cat(name: String) : Animal(name) {
    override fun move() {
        println("폴짝")
    }
}

interface Drawable {
    fun draw()
}

// value 를 수정할 수 있으면 var 를 붙여준다
class Box<T>(var value: T)
