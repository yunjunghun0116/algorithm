import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        StringBuilder stringBuilder = new StringBuilder();
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        stringBuilder.append(a + " + "+b+" = "+(a+b));

        System.out.println(stringBuilder);

    }
}
