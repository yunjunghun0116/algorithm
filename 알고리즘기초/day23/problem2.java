public class problem2 {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for (String str : str_list) {
            if (str.length() == str.replaceAll("(" + ex + ")", "").length()) {
                answer += str;
            }
        }
        return answer;
    }
}
