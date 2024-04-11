public class bible3 {
    public int solution(String my_string) {
        String str = my_string.replaceAll("[a-zA-Z]","");
        int answer = 0;
        for(int i= 0; i < str.length(); i++){
            answer+=  Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return answer;
    }
}
