import java.util.Scanner;

public class Main {
    public static int[][] dp = new int[1001][1001];
    public static int N, K;

    public static void main(String[] args) {
        //nCk = n팩/n-k팩*k팩 => 팩토리얼만 계산하면 될듯?
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        K = Integer.parseInt(sizeInput[1]);
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }
    }

    public static void solve() {
        System.out.println(dp[N][K]);
    }
}
