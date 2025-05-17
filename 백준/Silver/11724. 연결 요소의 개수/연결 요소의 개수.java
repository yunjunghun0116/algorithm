import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] board;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) {
        initialize();
        int result = solve();
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);

        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);

        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            String[] vInput = sc.nextLine().split(" ");
            int s = Integer.parseInt(vInput[0]);
            int e = Integer.parseInt(vInput[1]);

            board[s][e] = 1;
            board[e][s] = 1;
        }
    }

    public static int solve() {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            queue.add(i);
            cnt++;
            while (!queue.isEmpty()) {
                int number = queue.poll();
                if (visited[number]) continue;
                visited[number] = true;

                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue;
                    if (board[number][j] == 1) {
                        queue.add(j);
                    }
                }
            }
        }

        return cnt;
    }
}
