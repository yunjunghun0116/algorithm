import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        int size = Integer.parseInt(stringTokenizer.nextToken());

        int[][] grid = new int[size][size];
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine()," ");
            for(int j = 0; j < size; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer gcSt = new StringTokenizer(bufferedReader.readLine()," ");
        int r = Integer.parseInt(gcSt.nextToken())-1;
        int c = Integer.parseInt(gcSt.nextToken())-1;

        int value = grid[r][c];
        System.out.println("value = " + value);

        for(int i = r; i < size; i++){
            for(int j = c; j < size; j++){
                if(grid[i][j] < value){
                    grid[i][j] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(j == size-1){
                    sb.append(grid[i][j]+"\n");
                    continue;
                }
                sb.append(grid[i][j]+" ");
            }
        }

        System.out.println(sb);
    }
}
