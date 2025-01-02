import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        StringBuilder stringBuilder = new StringBuilder();
        String string1 = stringTokenizer.nextToken();
        String string2 = stringTokenizer.nextToken();

        stringBuilder.append(string1);
        stringBuilder.append(string2);

        System.out.println(stringBuilder);

    }
}
