import java.util.*;

public class problem2 {

    public static void main(String[] args) {
        int result = solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        System.out.println(result);
    }

    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] dx = new int[]{1, -1, 0, 0};


    public static int solution(String[] board) {
        int start_x = 0;
        int start_y = 0;
        int goal_x = 0;
        int goal_y = 0;

        int boardHeight = board.length;
        int boardWidth = board[0].length();

        boolean[][] positionBoard = new boolean[boardHeight][boardWidth];
        int[][] answer = new int[boardHeight][boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            Arrays.fill(answer[i], Integer.MAX_VALUE);
            Arrays.fill(positionBoard[i], true);

            for (int j = 0; j < boardWidth; j++) {
                if (String.valueOf(board[i].charAt(j)).equals("D")) {
                    positionBoard[i][j] = false;
                    continue;
                }
                if (String.valueOf(board[i].charAt(j)).equals("R")) {
                    start_y = i;
                    start_x = j;
                }
                if (String.valueOf(board[i].charAt(j)).equals("G")) {
                    goal_y = i;
                    goal_x = j;
                }
            }
        }

        answer[start_y][start_x] = 0;

        Stack<int[]> pointStack = new Stack<>();
        pointStack.push(new int[]{start_y, start_x, 0});

        while (!pointStack.isEmpty()) {
            int[] position = pointStack.pop();

            for (int i = 0; i < 4; i++) {
                int[] nextPosition = movePosition(positionBoard, position[0], position[1], dy[i], dx[i]);
                if (position[0] == nextPosition[0] && position[1] == nextPosition[1]) continue;
                if (position[2] + 1 < answer[nextPosition[0]][nextPosition[1]] ) {
                    answer[nextPosition[0]][nextPosition[1]] = position[2]+1;
                    pointStack.push(new int[]{nextPosition[0], nextPosition[1], position[2] + 1});
                }
            }
        }

        return answer[goal_y][goal_x] < Integer.MAX_VALUE ? answer[goal_y][goal_x] : -1;
    }

    public static int[] movePosition(boolean[][] board, int start_y, int start_x, int dy, int dx) {
        while (start_y >= 0 && start_y < board.length && start_x >= 0 && start_x < board[0].length && board[start_y][start_x]) {
            start_y += dy;
            start_x += dx;
        }
        start_y -= dy;
        start_x -= dx;
        return new int[]{start_y , start_x};
    }
}
