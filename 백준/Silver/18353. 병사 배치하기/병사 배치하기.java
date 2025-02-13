import java.util.Scanner;

public class Main {
    public static int N, MAX_LENGTH;
    public static int[] array, dp;

    public static void main(String[] args) {
        initialize();
        solve();
        System.out.println(N - MAX_LENGTH);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        array = new int[N];
        dp = new int[N];

        String[] arrayInput = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(arrayInput[i]);
        }
    }

    public static void solve() {
        dp[0] = 1;
        MAX_LENGTH = 1;
        for (int i = 1; i < N; i++) {
            int maxLength = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] <= array[i]) {
                    continue;
                }
                maxLength = Math.max(maxLength, dp[j]);
            }
            dp[i] = maxLength + 1;
            MAX_LENGTH = Math.max(MAX_LENGTH, dp[i]);
        }
    }
}
