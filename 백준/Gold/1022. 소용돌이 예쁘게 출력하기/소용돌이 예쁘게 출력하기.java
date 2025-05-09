import java.util.Scanner;

public class Main {
    static int R1, C1, R2, C2;
    static int[][] board;
    static String[][] outputBoard;

    public static void main(String[] args) {
        /*
         * 0단계 : 0(0,0 시작)
         * 1단계 : 1~9(0,1 시작)
         * 2단계 : 10~25(1,2 시작)
         * 3단계 : 26~49(2,3 시작)
         * n단계 : (2n-1)*(2n-1)+1 ~ (2n+1)*(2n+1), (n-1,n 시작)
         * */
        initialize();
        solve();
        update();
        print();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        R1 = Integer.parseInt(sizeInput[0]);
        C1 = Integer.parseInt(sizeInput[1]);
        R2 = Integer.parseInt(sizeInput[2]);
        C2 = Integer.parseInt(sizeInput[3]);

        int rowSize = R2 - R1 + 1;
        int colSize = C2 - C1 + 1;
        board = new int[rowSize][colSize];
        outputBoard = new String[rowSize][colSize];
    }

    public static void solve() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int row = i + R1;
                int col = j + C1;
                board[i][j] = findNumber(row, col);
            }
        }
    }

    public static void update() {
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                maxNumber = Math.max(maxNumber, board[i][j]);
            }
        }

        int maxLength = String.valueOf(maxNumber).length();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String number = String.valueOf(board[i][j]);
                String frontPadding = "";
                for (int k = 0; k < maxLength - number.length(); k++) {
                    frontPadding = " " + frontPadding;
                }
                outputBoard[i][j] = frontPadding + number;
            }
        }
    }

    public static void print() {
        for (int i = 0; i < outputBoard.length; i++) {
            for (int j = 0; j < outputBoard[0].length; j++) {
                System.out.print(outputBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findNumber(int i, int j) {
        int stage = getStage(i, j);
        if (stage == 0) return 1;
        int[] start = getStageStartIndex(stage);
        int startValue = getStartValue(stage);

        //top
        while (start[0] > -1 * stage) {
            if (start[0] == i && start[1] == j) {
                return startValue;
            }
            start[0] = start[0] - 1;
            startValue++;
        }
        //left
        while (start[1] > -1 * stage) {
            if (start[0] == i && start[1] == j) {
                return startValue;
            }
            start[1] = start[1] - 1;
            startValue++;
        }
        //down
        while (start[0] < stage) {
            if (start[0] == i && start[1] == j) {
                return startValue;
            }
            start[0] = start[0] + 1;
            startValue++;
        }
        //right
        while (start[1] < stage) {
            if (start[0] == i && start[1] == j) {
                return startValue;
            }
            start[1] = start[1] + 1;
            startValue++;
        }

        return startValue;
    }

    public static int getStage(int i, int j) {
        return Math.max(Math.abs(i), Math.abs(j));
    }

    public static int[] getStageStartIndex(int n) {
        return new int[]{n - 1, n};
    }

    public static int getStartValue(int n) {
        return (2 * n - 1) * (2 * n - 1) + 1;
    }
}
