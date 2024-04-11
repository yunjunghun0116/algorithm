import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(stringTokenizer.nextToken());

        boolean isOdd = n%2==1;

        stringBuilder.append(n+" is "+(isOdd?"odd":"even"));

        System.out.println(stringBuilder);

    }
}
