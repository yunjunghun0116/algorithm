import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] board;
    static int[][][] visitedCost;
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        // N*M*2 => 기본적으로는 첫번째층(k=0)에서 작업, 만약
        initialize();
        int result = solve();
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);

        board = new int[N][M];
        visitedCost = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String boardInput = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(boardInput.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visitedCost[i][j][0] = Integer.MAX_VALUE;
                visitedCost[i][j][1] = Integer.MAX_VALUE;
            }
        }
    }

    public static int solve() {
        Queue<int[]> queue = new LinkedList<>();
        
        visitedCost[0][0][0] = 1;
        queue.add(new int[]{0, 0, 0, 1});
        while (!queue.isEmpty()) {
            int[] polledItem = queue.poll();

            int row = polledItem[0];
            int col = polledItem[1];
            int depth = polledItem[2];
            int cost = polledItem[3];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dy[i];
                int nextCol = col + dx[i];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;
                int nextDepth = depth + board[nextRow][nextCol];
                int nextCost = cost + 1;
                if (nextDepth >= 2) continue;
                if (nextDepth == 1 && visitedCost[nextRow][nextCol][0] <= cost) continue;
                if (visitedCost[nextRow][nextCol][nextDepth] <= nextCost) continue;

                visitedCost[nextRow][nextCol][nextDepth] = nextCost;
                queue.add(new int[]{nextRow, nextCol, nextDepth, nextCost});
            }
        }

        int result = Math.min(visitedCost[N - 1][M - 1][0], visitedCost[N - 1][M - 1][1]);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}
