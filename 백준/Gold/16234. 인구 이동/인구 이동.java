import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[][] board;
    static int N, L, R;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        N = Integer.parseInt(sizeInput[0]);
        L = Integer.parseInt(sizeInput[1]);
        R = Integer.parseInt(sizeInput[2]);

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] boardInput = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }

    public static void solve() {
        int day = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean isMoved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if (dfs(i, j, visited)) {
                        isMoved = true;
                    }
                }
            }
            if (isMoved) {
                day++;
                continue;
            }
            break;
        }

        System.out.println(day);
    }

    public static boolean dfs(int y, int x, boolean[][] visited) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{y, x});

        List<int[]> positions = new ArrayList<>();
        int sum = 0;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            if (visited[pos[0]][pos[1]]) continue;
            visited[pos[0]][pos[1]] = true;
            positions.add(pos);
            sum += board[pos[0]][pos[1]];

            for (int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                int diff = Math.abs(board[ny][nx] - board[pos[0]][pos[1]]);
                if (diff < L) continue;
                if (diff > R) continue;
                stack.push(new int[]{ny, nx});
            }
        }
        int value = sum / positions.size();

        for (int[] pos : positions) {
            board[pos[0]][pos[1]] = value;
        }

        return sum != board[y][x];
    }
}
