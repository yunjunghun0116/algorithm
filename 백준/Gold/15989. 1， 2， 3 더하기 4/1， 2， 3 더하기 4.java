import java.util.Scanner;

public class Main {
    public static int[][] dp = new int[10001][3];

    public static void main(String[] args) {
        setDP();
        initialize();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());
            System.out.println(dp[number][0] + dp[number][1] + dp[number][2]);
        }
    }

    public static void setDP() {
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int i = 4; i < 10001; i++) {
            dp[i][0] = 1;
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
        }
    }
}
