fun main(){
    val items : MutableList<Int> = mutableListOf<Int>(1,2,3,4,5)
    // == val items = mutableListOf(1,2,3,4,5) == 자바의 ArrayList

    items.add(6)
    items.remove(2)

    val arrays = arrayOf(1,2,3)
    arrays[0] = 10
    val arr = Array<String>(10) { "" } // 사이즈 10이고 초기 값은 "" 인 배열

    try{
        val item = items[10];
    }catch(e:Exception){
        print(e.message)
    }

    var name : String? //nullable 데이터
    name = "정훈2"
    name = null

    var name2 : String = "낫널"
    if(name != null){
        name2 = name
    }

    // name2 = name!! 이거는 에러나면 개발자책임 -> 널체크하는게 나음
    // String 과 String? 은 엄연히 서로 다른 타입임
    name = name2

    name?.let{
        name2 = name
    }

    print(name2)
}
