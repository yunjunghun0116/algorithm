import java.util.StringTokenizer;

public class bible3 {
    public int solution(String my_string) {

        StringTokenizer st = new StringTokenizer(my_string," ");
        int size = st.countTokens();
        int answer =Integer.parseInt( st.nextToken());
        boolean isAdd = false;
        for(int i = 1; i < size; i++){
            String token = st.nextToken();
            if(i%2 == 1){
                if(token.equals("+")){
                    isAdd = true;
                }
                if(token.equals("-")){
                    isAdd = false;
                }
                continue;
            }
            if(isAdd){
                answer+=Integer.parseInt(token);
                continue;
            }
            answer-=Integer.parseInt(token);
        }
        return answer;
    }
}
