import java.util.*;

public class problem3 {
    public int solution(String[] strArr) {
        Map<Integer,Integer> strMap = new HashMap<>();
        for(String str : strArr){
            if(strMap.containsKey(str.length())){
                int value = strMap.get(str.length());
                strMap.put(str.length(),value+1);
                continue;
            }
            strMap.put(str.length(),1);
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : strMap.entrySet()){
            max = Math.max(max,entry.getValue());
        }
        return max;
    }
}
