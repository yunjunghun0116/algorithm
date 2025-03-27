import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] board;

    public static void main(String[] args) {
        initialize();
        setBoard(0, 0, N);
        print();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        board = new int[N][N];
    }

    public static void setBoard(int startY, int startX, int length) {
        if (length == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    board[startY + i][startX + j] = 1;
                }
            }
            return;
        }
        int addLen = length / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                setBoard(startY + addLen * i, startX + addLen * j, addLen);
            }
        }

    }

    public static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    stringBuilder.append("*");
                    continue;
                }
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
