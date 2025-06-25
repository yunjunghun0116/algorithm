import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);

        int testcase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcase; i++) {
            int size = Integer.parseInt(sc.nextLine());
            int[] files = new int[size];
            String[] fileInput = sc.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                files[j] = Integer.parseInt(fileInput[j]);
            }

            int result = solve(files);
            System.out.println(result);
        }
    }

    public static int solve(int[] files) {
        // 계속적으로 합치는 과정을 진행해 최종적으로 하나로 만들어야 한다.
        /*
| i\j | 1 | 2  | 3   | 4   |
| --- | - | -- | --- | --- |
| 1   | 0 | 70 | 160 | 300 |
| 2   |   | 0  | 60  | 170 |
| 3   |   |    | 0   | 80  |
| 4   |   |    |     | 0   |
        * */
        int size = files.length;
        int[] sum = new int[size + 1];
        int[][] dp = new int[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {
            sum[i] = sum[i - 1] + files[i - 1];
        }
        for (int len = 1; len < size + 1; len++) {
            for (int start = 1; start + len < size + 1; start++) {
                int end = start + len;
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k < end; k++) {
                    dp[start][end] = Math.min(
                            dp[start][end],
                            dp[start][k] + dp[k + 1][end] + sum[end] - sum[start - 1]
                    );
                }
            }
        }

        return dp[1][size];
    }
}
