import java.util.Arrays;

public class bible2 {
    public int[] solution(String my_string) {
        String str = my_string.replaceAll("[a-zA-Z]","");
        int[] answer = new int[str.length()];
        for(int i= 0; i < str.length(); i++){
            answer[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        Arrays.sort(answer);
        return answer;
    }
}
