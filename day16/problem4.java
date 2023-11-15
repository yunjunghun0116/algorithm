public class problem4 {
    public String solution(String myString) {
        String answer = myString.toLowerCase();
        String result = answer.replaceAll("[a|A]","A");
        return result;
    }
}
