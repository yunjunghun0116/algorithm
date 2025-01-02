fun main(){
    println(sum(10,20))
    // 입력 파라미터의 순서 변경 가능
    println(sum2(c=10, a=20, b=30))

    val john = Person("John", 20)
    val john2 = Person("John", 20)
    println(john.age)
    println(john)
    println(john == john2)
    println(john.hello())
    println(john.hobby)
    john.changeHobby("새로운 취미")
    println(john.hobby)

}
// 이거는 a,b 는 입력, 리턴타입은 함수에
fun sum(a: Int, b: Int): Int{
    return a+b
}

// Input 타입은 반드시 지정해줘야 함
fun sum2(a : Int, b : Int) = a+b

fun sum2(a : Int, b : Int, c : Int) = a + b + c

fun sum3(a : Int, b : Int, c : Int = 0) = a + b + c

// 클래스
// getter 와 setter 는 var, val 를 잘 활용하여 사용, setter 없도록 하려면 val 활용
// getter 제공 안하려면 private 을 활용
// data class : hashcode, equals 에서 값을 비교하여주기 때문
// 일반적인 클래스로 보려면 그냥 class 로 활용
data class Person(
    val name : String,
    var age : Int,
){
    var hobby : String = "취미"
        private set
        get() = "취미 : $field"

    init {
        println("init")
    }

    fun hello(){
        print(name)
    }

    fun changeHobby(hobby : String){
        this.hobby = hobby
    }
}
