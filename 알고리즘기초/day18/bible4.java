import java.util.Arrays;

public class bible4 {
    public String solution(String my_string) {
        char[] lowerCharArray = my_string.toLowerCase().toCharArray();
        Arrays.sort(lowerCharArray);

        return String.valueOf(lowerCharArray);
    }
}
