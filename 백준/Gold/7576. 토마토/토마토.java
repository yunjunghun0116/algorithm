import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int N, M, result;
    static Queue<Item> queue = new LinkedList<>();

    public static void main(String[] args) {
        initialize();
        solve();
        check();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        M = Integer.parseInt(sizeInput[0]);
        N = Integer.parseInt(sizeInput[1]);
        result = Integer.MIN_VALUE;
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] lineInput = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(lineInput[j]);
                if (board[i][j] == 1) {
                    queue.add(new Item(i, j, 0));
                }
            }
        }
    }

    public static void solve() {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (visited[item.y][item.x]) continue;
            board[item.y][item.x] = 1;
            visited[item.y][item.x] = true;
            result = Math.max(result, item.day);
            for (int i = 0; i < 4; i++) {
                int nextY = item.y + dy[i];
                int nextX = item.x + dx[i];
                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;
                if (board[nextY][nextX] != 0) continue;
                if (visited[nextY][nextX]) continue;
                queue.add(new Item(nextY, nextX, item.day + 1));
            }
        }
    }

    public static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);
    }

    static class Item {
        int y;
        int x;
        int day;

        public Item(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
