import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        String string = stringTokenizer.nextToken();
        int n = Integer.parseInt(stringTokenizer.nextToken());

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<n;i++){
            stringBuilder.append(string);
        }
        System.out.println(stringBuilder);
    }
}
