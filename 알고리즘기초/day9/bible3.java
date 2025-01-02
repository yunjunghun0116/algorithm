import java.util.HashMap;
import java.util.Map;

public class bible3 {
    public String solution(String rsp) {
        Map<String,String> rspMap = new HashMap<>(){{
            put("2","0");
            put("0","5");
            put("5","2");
        }};

        String answer = "";

        for(int i = 0; i < rsp.length(); i++){
            answer += rspMap.get(String.valueOf(rsp.charAt(i)));
        }
        return answer;
    }
}
