public class bible4 {
    public int solution(int n) {
        int maxN = n / 2;
        return 2 * ((int) Math.pow(maxN, 2) + maxN) / 2;
    }
}
