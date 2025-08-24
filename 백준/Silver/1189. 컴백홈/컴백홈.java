import java.util.Scanner;

public class Main {
    static boolean[][] board;
    static boolean[][] visited;
    static int N, S, E, answer = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        initialize();
        visited[S][0] = true;
        dfs(S, 0, 1);
        System.out.println(answer);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine()
                               .split(" ");
        int r = Integer.parseInt(sizeInput[0]);
        int c = Integer.parseInt(sizeInput[1]);
        N = Integer.parseInt(sizeInput[2]);

        S = r - 1;
        E = c - 1;
        board = new boolean[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String rowInput = sc.nextLine();
            for (int j = 0; j < c; j++) {
                if (rowInput.charAt(j) == '.') {
                    board[i][j] = true;
                    continue;
                }
                board[i][j] = false;
            }
        }
    }

    public static void dfs(int y, int x, int dist) {
        // 목표 지점: 오른쪽 위 (0, C-1)에 도달했을 때
        if (y == 0 && x == E) {
            if (dist == N) {
                answer++;
            }
            return;
        }

        // 4방향 탐색 (상, 하, 좌, 우)
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (!canMove(nextY, nextX)) continue;

            visited[nextY][nextX] = true;
            dfs(nextY, nextX, dist + 1);
            visited[nextY][nextX] = false;
        }
    }

    public static boolean canMove(int Y, int X) {
        if (Y < 0 || Y >= board.length || X < 0 || X >= board[0].length) return false;
        if (visited[Y][X]) return false;
        return board[Y][X];
    }


}
