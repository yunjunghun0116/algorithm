import java.util.*;

public class problem4 {
    public int[] solution(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arrList.size()==0){
                arrList.add(arr[i]);
                continue;
            }
            if(arrList.get(arrList.size()-1).equals(arr[i])){
                arrList.remove(arrList.size()-1);
                continue;
            }
            arrList.add(arr[i]);
        }
        if(arrList.isEmpty()){
            return new int[]{-1};
        }
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}
