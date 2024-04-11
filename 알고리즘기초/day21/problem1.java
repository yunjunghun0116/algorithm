import java.util.Arrays;

public class problem1 {
    public int[] solution(int[] num_list) {
        int[] answer = num_list;
        int[] result = new int[answer.length-5];
        Arrays.sort(answer);
        System.arraycopy(answer,5,result,0,result.length);
        return result;
    }
}
