import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long result = getOutCount(r2) - getInCount(r1);
        return result;
    }
    
    public static long getOutCount(int r) {
        // 6: 0 - 6, 1 - 5, 2-5,3-5,4-4,5-3
        long result = 0;
        long rPow = (long) Math.pow(r, 2);
        for (int i = 0; i < r; i++) {
            result += (int)Math.sqrt((rPow - Math.pow(i, 2)));
        }

        return 4 * result;
    }

    public static long getInCount(int r) {
        long result = 0;
        double rPow =  Math.pow(r, 2);
        long count = 0;
        for (int i = 0; i < r; i++) {
            int sqrt = (int)Math.sqrt(rPow - Math.pow(i, 2));
            if (sqrt>0 &&Math.pow(sqrt,2) == (rPow - Math.pow(i, 2))) {
                count++;
            }
            result += sqrt;
        }

        return 4 * (result - count);
    }
}