package 기초문법

fun main() {

    myFunc("hello") {
        println("콜백 함수 호출")
    }
}

// 리턴값이 없는 경우 Unit 으로
// suspend 함수 : 끝날때까지 기달려줘야함
// 코루틴이 뭘까
fun myFunc(
    name: String?, callback: (value: String?) -> Unit = {
        println(name)
    }
) {
    println("함수 시작")
    callback(name)
    println("함수 끝")
}
