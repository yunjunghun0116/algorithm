import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int N;
    public static int[][] board;
    public static int[][] result;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        board = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] boardInput = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            dfs(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int index) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        stack.push(index);

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            if (visited[idx]) continue;
            visited[idx] = true;

            int[] dist = board[idx];
            for (int i = 0; i < N; i++) {
                if (i == idx) continue;
                if (dist[i] == 1) {
                    stack.push(i);
                    result[index][i] = 1;
                }
            }
        }
    }
}
