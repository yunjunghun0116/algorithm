import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class more_problem {

    //정규식 이용한 문제 풀이
    public static int solution(String[] babbling) {
        int answer = 0;
        String reg = "^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher;
        for (String str : babbling) {
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                answer++;
            }
        }
        return answer;
    }

    // replace를 이용한 문제 풀이
    public static int solution2(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            String s = str.replace("aya", "1").replace("ye", "1").replace("woo", "1").replace("ma", "1");
           s = s.replace("1","");
            if (s.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}
