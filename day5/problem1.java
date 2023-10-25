public class problem1 {
    public String solution(String code) {
        String answer = "";
        boolean mode = false;
        for (int i = 0; i < code.length(); i++) {
            char character = code.charAt(i);
            if (character == '1') {
                mode = !mode;
                continue;
            }
            if (mode) {
                answer += i % 2 == 1 ? character : "";
                continue;
            }
            answer += i % 2 == 0 ? character : "";
        }
        if (answer.length() == 0) return "EMPTY";
        return answer;
    }
}
