import java.util.*;

public class problem2 {
    public int[] solution(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for(int num:arr){
            for(int i =0; i < num; i++){
                arrList.add(num);
            }
        }
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}
