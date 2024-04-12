class Solution {
    public int solution(int n) {
        int[] dp = new int[15];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < 15;i++){
            int sum = 0;
            for(int j = i; j > 0; j--){
                sum += dp[j-1]*dp[i-j];
            }
            dp[i] = sum;
        }

        return dp[n];
    }
}