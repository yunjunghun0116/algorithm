public class problem1 {
    public int[] solution(int brown, int yellow) {
        int sumCount = (brown-4)/2;
        int multipleCount = yellow;
        /**
         * m + n = sumCount
         * m * n = multipleCount
         * m > n
         * m - n = subCount
         */

        int subCount = (int) Math.sqrt(Math.pow(sumCount,2)-4*multipleCount);
        int m = (sumCount + subCount)/2;
        int n = sumCount - m;
        int[] answer = {m+2,n+2};
        return answer;
    }
}
