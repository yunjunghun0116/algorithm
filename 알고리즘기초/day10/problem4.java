public class problem4 {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int index = c-1;
        for(int i = 0; i < my_string.length()/m; i++){
            answer += my_string.charAt(m*i+index);
        }
        return answer;
    }
}
