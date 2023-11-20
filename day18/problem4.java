public class problem4 {
    public int solution(String myString, String pat) {
        String changedString = myString.replaceAll("B","b").replaceAll("A","B").replaceAll("b","A");
        for(int i = 0; i <= myString.length()-pat.length(); i++){
            if(changedString.substring(i,i+pat.length()).equals(pat)){
                return 1;
            }
        }
        return 0;
    }
}
