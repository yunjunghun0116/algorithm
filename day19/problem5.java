import java.util.*;

public class problem5 {
    public int[] solution(int[] arr, int k) {
        int[] answer = Arrays.stream(arr).distinct().toArray();
        List<Integer> arrList = new ArrayList<>();
        for(int i =0;i<k;i++){
            if(i<answer.length){
                arrList.add(answer[i]);
                continue;
            }
            arrList.add(-1);
        }
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}
