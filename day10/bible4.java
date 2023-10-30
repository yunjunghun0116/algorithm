public class bible4 {
    public int[] solution(int[] numbers, String direction) {
        if(direction.equals("left")) return left(numbers);
        return right(numbers);
    }
    public int[] left(int[] numbers){
        int[] newArr = new int[numbers.length];
        System.arraycopy(numbers,1,newArr,0,numbers.length-1);
        newArr[numbers.length-1] = numbers[0];
        return newArr;
    }

    public int[] right(int[] numbers){
        int[] newArr = new int[numbers.length];
        System.arraycopy(numbers,0,newArr,1,numbers.length-1);
        newArr[0] = numbers[numbers.length-1];
        return newArr;
    }
}
