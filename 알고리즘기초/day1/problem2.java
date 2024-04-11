import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a = "+a+"\n");
        stringBuilder.append("b = "+b+"\n");
        System.out.println(stringBuilder);
    }
}
