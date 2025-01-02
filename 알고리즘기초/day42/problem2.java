import java.util.HashMap;
import java.util.Map;

public class problem2 {

    public static void main(String[] args) {
        int result = solution(4, 7, new int[][]{{6, 13}, {4, 8}, {3, 6}, {5, 12}});
        System.out.println(result);
    }

    public static int solution(int n, int k, int[][] wv) {
        int[][] dp = new int[n + 1][k + 1];
        Map<Integer, int[]> wvMap = new HashMap<>();
        for (int i = 1; i <= wv.length; i++) {
            wvMap.put(i, wv[i - 1]);
        }

        for (int i = 1; i < n + 1; i++) {
            int[] weightValue = wvMap.get(i); //weight, value
            for (int j = 1; j < k + 1; j++) {
                if (j < weightValue[0]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weightValue[0]] + weightValue[1]);
            }
        }
        return dp[n][k];
    }
}
