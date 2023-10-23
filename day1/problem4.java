import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        String string = stringTokenizer.nextToken();
        int n = string.length();
        StringBuilder stringBuilder = new StringBuilder();
        // 1. 내 풀이 (아스키코드값 사용)
        for (int i = 0; i < n; i++) {
            char character = string.charAt(i);
            char swapCharacter;
            if (character < 90) {

                swapCharacter = (char)(character + 32);
                stringBuilder.append(swapCharacter);
                continue;
            }
            swapCharacter =(char)(character -32);
            stringBuilder.append(swapCharacter);
        }

        System.out.println(stringBuilder);
        // 2. 다른 사람 풀이(내부 함수 사용)
        for(Character c : string.toCharArray()){
            if(Character.isUpperCase(c)){
                stringBuilder.append(Character.toLowerCase(c));
            }
            if(Character.isLowerCase(c)){
                stringBuilder.append(Character.toUpperCase(c));
            }
        }
        System.out.println(stringBuilder);
    }
}
