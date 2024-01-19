public class problem1 {

    public static void main(String[] args) {
        int result = solution(new int[][]{{7},{3, 8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}});
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < i+1; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
            for(int k = 0; k < dp.length; k++){
                System.out.print(dp[i][k] + ", ");
            }
            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        for(int sum : dp[triangle.length-1]){
            System.out.println(sum);
            max = Math.max(max,sum);
        }
        return max;
    }
}
