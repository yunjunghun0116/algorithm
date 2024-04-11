import java.util.HashSet;
import java.util.Set;

public class bible3 {
    public String solution(String my_string) {
        Set wordSet = new HashSet();
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(wordSet.contains(c)){
                continue;
            }
            answer+=c;
            wordSet.add(c);
        }
        return answer;
    }
}
