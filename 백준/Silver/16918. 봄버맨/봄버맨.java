import java.util.Scanner;

public class Main {
    public static int[][] matrix;
    public static int time;

    public static void main(String[] args) {
        initialize();
        bombermanProcess();
        printMatrix();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        int n = Integer.parseInt(sizeInput[0]);
        int m = Integer.parseInt(sizeInput[1]);
        time = Integer.parseInt(sizeInput[2]);

        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String rowInput = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (rowInput.charAt(j) == '.') {
                    matrix[i][j] = -1;
                    continue;
                }
                matrix[i][j] = 0;
            }
        }
    }

    public static void bombermanProcess() {
        if (time == 1) return;
        // 1 : 그대로
        // 2 : 설치
        // 3:  터짐
        // 4 : 설치
        // 5 : 터짐
        // 6 : 설치
        // 7 : 터짐
        // 8 : 설치
        // 9 : 터짐
        // 10 : 설치
        for (int t = 2; t <= time; t++) {
            if (t % 2 == 0) {
                setAllBomb(t);
                continue;
            }
            boomBomb(t);
        }
    }

    public static void setAllBomb(int t) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = t;
                }
            }
        }
    }

    public static void boomBomb(int t) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        boolean[][] bombMatrix = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) continue;
                if (t - matrix[i][j] > 2) {
                    bombMatrix[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if (isInBound(nextY, nextX)) {
                            bombMatrix[nextY][nextX] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (bombMatrix[i][j]) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static boolean isInBound(int y, int x) {
        if (y < 0 || x < 0 || y >= matrix.length || x >= matrix[0].length) return false;
        return true;
    }

    public static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] == -1 ? "." : "O");
            }
            System.out.println();
        }
    }
}
