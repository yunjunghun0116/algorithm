import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        StringBuilder stringBuilder = new StringBuilder();
        String string = stringTokenizer.nextToken();
        int n = string.length();

        for(char c : string.toCharArray()){
            stringBuilder.append(c+"\n");
        }

        System.out.println(stringBuilder);

    }
}
