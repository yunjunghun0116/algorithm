import java.util.Scanner;

public class Main {
    static int[][] dp;
    static int N, K;
    static int[] coins;

    public static void main(String[] args) {
        initialize();
        System.out.println(solve());
    }
    // 100 100 200 500
    // 200 200 500
    // 100 100 100 200 200 200
    // 마지막에 사용한 금액을 기준으로 이어서 추가할 수 있으면 추가하고, 아니면 넘어가도록 하면 안되려나
    // dfs? dp?
    // 오름차순으로만 찾아내면 될 것 같은데
    // 1, 100, 10000 ->100 * 100 * 100,,dfs 안될것같은데
    // dp -> 겹치는 것을 치워야 하고, 1,1,1,1,1,1,1,1, ... 부터 하나씩 2로 바꾸는 건 -> 10000/k*k
    // 1: 1개 (1,...)
    // 2: 5개 (2가 1,2,3,4,5개)
    // 5: 4개 (5 1개, 2 0개, 5 1개 2 1개 5 1개 2 2개 5 2개)
    // 2
    // 0 1 2 3 4 5 6 7 8 9 10
    // 1 1 1 1 1 1 1 1 1 1 1
    // 1 1 2 2 3 3 4 4 5 5 6
    // 1 1 2 2 3 4 5 6 7 8 10
    // dp[i] = dp[i] + dp[i-v[i]]

    static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        K = Integer.parseInt(sizeInput[1]);

        dp = new int[N + 1][K + 1];
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }
    }

    static int solve() {
        for (int i = 1; i <= N; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= K; j++) {
                if (j < coin) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
            }
        }
        return dp[N][K];
    }
}
