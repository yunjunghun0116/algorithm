import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        String answer = "";
        for(int i = b; i <= a; i++){
            if(i%2==0){
                if(answer.length() == 0){
                    answer+=(i);
                    continue;
                }
                answer+=(" "+i);
            }
        }

        System.out.println(answer);
    }
}
