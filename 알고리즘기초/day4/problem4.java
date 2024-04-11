public class problem4 {
    public int solution(String ineq, String eq, int n, int m) {
        boolean equal = eq.equals("=");
        boolean big = ineq.equals(">");
        if (equal) {
            boolean correct = big ? n >= m : n <= m;
            return correct ? 1 : 0;
        }
        boolean correct = big ? n > m : n < m;
        return correct ? 1 : 0;
    }
}
