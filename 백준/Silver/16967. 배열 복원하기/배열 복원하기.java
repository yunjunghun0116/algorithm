import java.util.Scanner;

public class Main {

    public static int H, W, X, Y;
    public static int[][] A, B;

    public static void main(String[] args) {
        initialize();
        findArray();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        H = Integer.parseInt(sizeInput[0]);
        W = Integer.parseInt(sizeInput[1]);
        X = Integer.parseInt(sizeInput[2]);
        Y = Integer.parseInt(sizeInput[3]);

        A = new int[H][W];
        B = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            String[] lineInput = sc.nextLine().split(" ");
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(lineInput[j]);
            }
        }
    }

    public static void findArray() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = B[i][j];
            }
        }

        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                A[i][j] = A[i][j] - A[i - X][j - Y];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
