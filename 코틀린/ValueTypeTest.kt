// main 보다 우선으로 생성이 되며, 컴파일 타임 상수라고 생각하면 된다.
const val constValue : Double = 13.5

fun main(){
    println("Hello World")
    // 변수 : var, 상수 : val
    var age : Int = 10
    var name :String= "정훈"
    var point  : Double= 3.3
    val age2 : Int = 13

    //형 변환
    var i = 10
    var j = 10L
    i = j.toInt()
    j = i.toLong()

    name = i.toString()
    val list =  ArrayList<String>()
    var result = list.map {
        obj -> obj.toLong()
    }

    printMethod()
}

fun printMethod(){
    val name = "정훈"
    print("제 이름은 $name 입니다.")
}
