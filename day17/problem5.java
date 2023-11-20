import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem5 {
    public String[] solution(String my_string) {
        //trim() 메소드는 가장 끝(좌우)의 공백을 제거해줍니다.
        String str= my_string.replaceAll("\\s+"," ").replaceAll("^\\s","").replaceAll("\\s$","");
        StringTokenizer st = new StringTokenizer(str);
        String[] answer = new String[st.countTokens()];
        for(int i = 0;i<answer.length; i++){
            answer[i] = st.nextToken();
        }
        return answer;
    }
}
