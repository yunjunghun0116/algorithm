public class problem1 {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i = myString.length(); i>= pat.length(); i--){
            String subStr = myString.substring(i-pat.length(),i);
            if(subStr.equals(pat)){
                return myString.substring(0,i);
            }
        }
        return answer;
    }
}
