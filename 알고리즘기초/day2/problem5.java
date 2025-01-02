public class problem5 {
    public String solution(String my_string, String overwrite_string, int s) {
        int overwrite_length = overwrite_string.length();
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (i < s || i >= overwrite_length + s) {
                answer += my_string.charAt(i);
                continue;
            }
            answer += overwrite_string.charAt(i - s);
        }
        return answer;
    }
}
