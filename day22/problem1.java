public class problem1 {
    public String solution(String n_str) {
        String answer = n_str.replaceAll("^0+","");
        return answer;
    }
}
