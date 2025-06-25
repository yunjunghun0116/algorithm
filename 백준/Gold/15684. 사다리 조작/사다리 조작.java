import java.util.Scanner;

public class Main {
    static int N, M, H;
    static boolean[][] ladders;
    static int result = -1;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);
        H = Integer.parseInt(sizeInput[2]);

        ladders = new boolean[H][N - 1];
        for (int i = 0; i < M; i++) {
            String[] ladderInput = sc.nextLine().split(" ");
            int a = Integer.parseInt(ladderInput[0]) - 1;
            int b = Integer.parseInt(ladderInput[1]) - 1;
            ladders[a][b] = true;
        }
    }

    public static void solve() {
        int canPutLadderCnt = 0;
        while (canPutLadderCnt <= 3) {
            if (result != -1) break;
            backtracking(0, canPutLadderCnt, 0);
            canPutLadderCnt++;
        }
        System.out.println(result);
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            int currCol = i;
            for (int j = 0; j < H; j++) {
                // 왼쪽으로 갈 수 있는지
                if (currCol > 0 && ladders[j][currCol - 1]) {
                    currCol -= 1;
                    continue;
                }
                // 오른쪽으로 갈 수 있는지
                if (currCol < N - 1 && ladders[j][currCol]) {
                    currCol += 1;
                }
            }
            if (currCol != i) return false;
        }
        return true;
    }

    public static boolean canPutLadder(int row, int col) {
        if (row >= H || col >= N - 1) return false;
        if (ladders[row][col]) return false;
        // 왼쪽에 있으면 false
        if (col > 0 && ladders[row][col - 1]) return false;
        // 오른쪽에 있으면 false
        if (col < N - 2 && ladders[row][col + 1]) return false;
        return true;
    }

    public static void backtracking(int pos, int canUseLadderCnt, int currPutLadderCnt) {
        if (result != -1) return;
        if (canUseLadderCnt == currPutLadderCnt) {
            if (check()) {
                result = currPutLadderCnt;
            }
            return;
        }

        if (pos >= H * (N - 1)) return;

        int row = pos / (N - 1);
        int col = pos % (N - 1);

        if (canPutLadder(row, col)) {
            ladders[row][col] = true;
            backtracking(pos + 1, canUseLadderCnt, currPutLadderCnt + 1);
            ladders[row][col] = false;
        }
        backtracking(pos + 1, canUseLadderCnt, currPutLadderCnt);
    }
}
