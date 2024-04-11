public class bible3 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numerResult = numer1 * denom2 + numer2 * denom1;
        int denomResult = denom1 * denom2;
        int minimum = Math.min(numerResult, denomResult);
        int n = 2;
        while (n <= minimum) {
            if (numerResult % n == 0 && denomResult % n == 0) {
                numerResult = numerResult / n;
                denomResult = denomResult / n;
                minimum = minimum / n;
                n = 2;
                continue;
            }
            n++;
        }
        int[] answer = {numerResult, denomResult};
        return answer;
    }
}
