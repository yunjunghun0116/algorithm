import java.util.Scanner;

public class Main {
    static int[][] board;
    static int[][] visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static int result = Integer.MAX_VALUE;
    static int N,M;
    public static void main(String[] args) {
        initialize();
        dfs(0,0,1);
        System.out.println(result);
    }
    public static void initialize(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);

        board = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = sc.nextLine();
            for(int j = 0; j < M ; j++){
                board[i][j]= Integer.parseInt(String.valueOf(str.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    public static void dfs(int y, int x, int length){
        if(visited[y][x] <= length)return;
        visited[y][x] = length;
        if(y == N-1 && x == M-1){
            result = Math.min(result, length);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;
            if(board[nextY][nextX] == 0) continue;
            dfs(nextY,nextX,length+1);
        }
    }
}
