import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bible2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        StringBuilder stringBuilder = new StringBuilder();
        int count = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j <= i; j++) {
                stringBuilder.append("*");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
