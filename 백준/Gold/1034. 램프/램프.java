import java.util.Scanner;

public class Main {
    public static int[][] board;
    public static int K;

    public static void main(String[] args) {
        initialize();
        int result = solve();
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        int n = Integer.parseInt(sizeInput[0]);
        int m = Integer.parseInt(sizeInput[1]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String rowInput = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(rowInput.charAt(j)));
            }
        }

        K = Integer.parseInt(sc.nextLine());
    }

    public static int solve() {
        int maxValue = 0;

        for (int row = 0; row < board.length; row++) {
            int zeroCount = getZeroCount(row);
            if (zeroCount > K) continue;
            if (zeroCount % 2 != K % 2) continue;
            int sameCnt = 0;
            for (int nextRow = 0; nextRow < board.length; nextRow++) {
                if (checkSame(row, nextRow)) {
                    sameCnt++;
                }
            }
            maxValue = Math.max(maxValue, sameCnt);
        }

        return maxValue;
    }

    public static int getZeroCount(int row) {
        int zeroCount = 0;
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 0) zeroCount++;
        }
        return zeroCount;
    }

    public static boolean checkSame(int base, int target) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[base][i] != board[target][i]) return false;
        }
        return true;
    }
}
