public class bible4 {
    public String solution(String my_string) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c < 97){
                answer += String.valueOf(c).toLowerCase();
                continue;
            }
            answer += String.valueOf(c).toUpperCase();

        }
        return answer;
    }
}
