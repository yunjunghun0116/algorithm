class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        boolean[][] puddlePosition = new boolean[n+1][m+1];

        for (int[] position : puddles) {
            puddlePosition[position[1]][position[0]] = true;
        }

        dp[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(i==1 && j==1) continue;
                if (puddlePosition[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }

        return (dp[n][m]) % 1000000007;
    }
}