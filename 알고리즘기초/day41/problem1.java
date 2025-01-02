public class problem1 {

    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }

    public static long solution(int r1, int r2) {
        long count = 0;
        double r1Pow = Math.pow(r1, 2);
        double r2Pow = Math.pow(r2, 2);

        for (int i = 0; i < r2; i++) {
            double r1Sqrt = Math.sqrt((r1Pow - Math.pow(i, 2)));
            double r2Sqrt = Math.sqrt((r2Pow - Math.pow(i, 2)));
            int result = (int) r2Sqrt - (int) r1Sqrt;
            int flagValue = 0;
            if (r1Sqrt > 0 && (r1Sqrt % 1) == 0) {
                flagValue++;
            }

            count += result  + flagValue ;
        }
        return count * 4 ;
    }

    public static long getOutCount(int r) {
        // 6: 0 - 6, 1 - 5, 2-5,3-5,4-4,5-3
        long result = 0;
        double rPow =  Math.pow(r, 2);
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
