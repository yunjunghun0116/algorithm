import java.util.Arrays;

public class problem1 {
    public String[] solution(String myStr) {
        String changedStr = myStr.replaceAll("[a|b|c]","a");
        String[] answer = Arrays.stream(changedStr.split("a")).filter(s->!s.isEmpty()).toArray(String[]::new);
        if(answer.length == 0){
            String[] empty = {"EMPTY"};
            return empty;
        }
        return answer;
    }
}

