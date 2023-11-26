import java.util.*;

public class problem3 {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int value = arr[i];
            if(flag[i]){
                for(int j = 0; j < value*2; j++){
                    arrList.add(value);
                }
                continue;
            }
            arrList = arrList.subList(0,arrList.size()-value);
        }
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}
