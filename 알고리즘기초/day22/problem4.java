import java.util.Arrays;

public class problem4 {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = Arrays.stream(arr).filter((value)-> Arrays.stream(delete_list).noneMatch((val)->value==val)).toArray();

        return answer;
    }
}
