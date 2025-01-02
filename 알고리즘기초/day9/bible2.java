import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bible2 {
    public String solution(String letter) {
        Map<String, String> morseMap = new HashMap<String, String>() {
            {
                put(".-", "a");
                put("-...", "b");
                put("-.-.", "c");
                put("-..", "d");
                put(".", "e");
                put("..-.", "f");
                put("--.", "g");
                put("....", "h");
                put("..", "i");
                put(".---", "j");
                put("-.-", "k");
                put(".-..", "l");
                put("--", "m");
                put("-.", "n");
                put("---", "o");
                put(".--.", "p");
                put("--.-", "q");
                put(".-.", "r");
                put("...", "s");
                put("-", "t");
                put("..-", "u");
                put("...-", "v");
                put(".--", "w");
                put("-..-", "x");
                put("-.--", "y");
                put("--..", "z");
            }
        };
        StringTokenizer stringTokenizer = new StringTokenizer(letter," ");
        String answer = "";
        while( stringTokenizer.hasMoreTokens()){
            answer+=morseMap.get(stringTokenizer.nextToken());
        }


        return answer;
    }
}
