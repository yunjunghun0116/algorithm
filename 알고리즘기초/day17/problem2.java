public class problem2 {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i = 0; i <= myString.length()-pat.length(); i++){
            String subStr = myString.substring(i,i+pat.length());
            if(subStr.equals(pat)){
                answer++;
            }
        }
        return answer;
    }
}
