public class problem5 {
    public String solution(String my_string, String alp) {
        String answer = my_string.toLowerCase();
        String result = answer.replaceAll(alp.toLowerCase(),alp.toUpperCase());
        return result;
    }
}
