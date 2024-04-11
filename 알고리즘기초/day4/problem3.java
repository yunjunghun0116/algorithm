public class problem3 {
    public int solution(int n) {
        int answer = 0;
        if (n % 2 == 0) {
            for (int i = 1; 2 * i <= n; i++) {
                // Math.pow(a,b) = a의 b제곱을 리턴
                answer += Math.pow(2 * i, 2);
            }
            return answer;
        }
        for (int i = 1; 2 * i - 1 <= n; i++) {
            answer += (2 * i - 1);
        }
        return answer;
    }
}
