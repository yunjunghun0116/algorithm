class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < i+1; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j]; 
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+ triangle[i][j];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int sum : dp[triangle.length-1]){
            max = Math.max(max,sum);
        }
        return max;
    }
}