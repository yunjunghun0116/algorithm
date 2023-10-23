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
    }
}
