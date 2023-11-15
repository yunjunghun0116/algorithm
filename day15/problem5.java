public class problem5 {
    public int solution(String myString, String pat) {
        String str = myString.toLowerCase();
        String pattern = pat.toLowerCase();
        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            String subStr = str.substring(i, i + pattern.length());
            if (subStr.equals(pattern)) return 1;
        }
        return 0;
    }
}
