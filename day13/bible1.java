import java.util.StringTokenizer;

public class bible1 {
    public int solution(String s) {
        StringTokenizer st = new StringTokenizer(s," ");
        String[] str_list = new String[st.countTokens()];
        for(int i= 0 ; i < str_list.length; i++){
            str_list[i] = st.nextToken();
        }
        int answer = 0;
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("Z")){
                answer -= Integer.parseInt(str_list[i-1]);
                continue;
            }
            answer+= Integer.parseInt(str_list[i]);
        }
        return answer;
    }
}
