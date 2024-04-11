public class problem5 {
    public int solution(int a, int b) {
        int answer = 0;
        String s1 = Integer.toString(a) + Integer.toString(b);
        answer = Math.max(Integer.parseInt(s1), 2 * a * b);
        return answer;
    }
}
