import java.util.Arrays;

public class problem3 {
    public String solution(String my_string, int[] indices) {
        boolean[] stringCheck = new boolean[my_string.length()];
        for(int i = 0; i < indices.length; i++){
            stringCheck[indices[i]] = true;
        }
        String answer = "";
        for(int i = 0; i < my_string.length() ;i++){
            if(stringCheck[i]) continue;
            answer+=my_string.charAt(i);
        }

        return answer;
    }
}
