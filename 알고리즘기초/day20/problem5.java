import java.util.Arrays;

public class problem5 {
    public int[] solution(int[] num_list) {
        int[] answer = num_list;
        Arrays.sort(answer);
        int[] result = new int[5];
        System.arraycopy(answer,0,result,0,result.length);
        return result;
    }
}
