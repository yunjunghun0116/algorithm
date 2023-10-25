public class problem2 {
    public int solution(int n, String control) {
        int answer = n;
        for (char character : control.toCharArray()) {
            if (character == 'w') {
                answer += 1;
            }
            if (character == 's') {
                answer -= 1;
            }
            if (character == 'd') {
                answer += 10;
            }
            if (character == 'a') {
                answer -= 10;
            }
        }
        return answer;
    }
}
