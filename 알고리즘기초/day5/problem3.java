public class problem3 {
    public int solution(int a, int b, int c) {
        if (a != b && a != c && b != c) {
            return a + b + c;
        }
        double doubleValue = (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        if (a == b && a == c && b == c) {
            return (int) ((a + b + c) * doubleValue * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)));
        }
        return (int) ((a + b + c) * doubleValue);
    }
}
