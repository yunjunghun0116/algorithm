import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bible4 {
    public int[] solution(int n) {
        Map<Integer,Integer> numMap = new HashMap<>();
        int divider = 2;
        int number = n;
        while(number>1){
            if(number%divider == 0){
                if(!numMap.containsKey(divider)){
                    numMap.put(divider,1);
                }
                number = number/divider;
                divider = 2;
                continue;
            }
            divider++;
        }

        int[] answer = new int[numMap.size()];
        int index = 0;
        for(Map.Entry entry:numMap.entrySet()){
            answer[index++] = (int)entry.getKey();
        }

        Arrays.sort(answer);
        return answer;
    }
}
