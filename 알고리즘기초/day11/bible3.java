import java.util.Arrays;

public class bible3 {
    public int solution(int[] numbers) {
        int[] sortedArray =  numbers;
        Arrays.sort(sortedArray);
        return sortedArray[sortedArray.length-1]*sortedArray[sortedArray.length-2];
    }
}
