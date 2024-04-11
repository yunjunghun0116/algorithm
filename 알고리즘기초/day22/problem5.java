public class problem5 {
    public int solution(String my_string, String target) {
        for (int i = 0; i <= my_string.length() - target.length(); i++) {
            String str = my_string.substring(i, i + target.length());
            if (str.equals(target)) {
                return 1;
            }
        }
        return 0;
    }
}
