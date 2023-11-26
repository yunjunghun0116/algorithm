import java.util.Arrays;

public class bible3 {
    public int solution(int[] numbers) {
        int[] numArr = numbers;
        Arrays.sort(numArr);

        return Math.max(numArr[numArr.length-1]*numArr[numArr.length-2],numArr[0]*numArr[1]);
    }
}
