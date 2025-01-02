import java.util.*;

public class bible3 {
    public String solution(String s) {
        String answer = "";
        Map<String,Integer> countMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            String key = String.valueOf(s.charAt(i));
            if(countMap.containsKey(key)){
                int value = countMap.get(key);
                countMap.put(key,value+1);
                continue;
            }
            countMap.put(key,1);
        }

        for(Map.Entry<String,Integer> entry:countMap.entrySet()){
            if(entry.getValue() == 1){
                answer+=entry.getKey();
            }
        }

        char[] characterArr = answer.toCharArray();
        Arrays.sort(characterArr);

        return String.valueOf(characterArr);
    }
}
