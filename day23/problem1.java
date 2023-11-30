public class problem1 {
    public int solution(String str1, String str2) {
        for(int i = 0; i <= str2.length() - str1.length(); i++){
            if(str2.substring(i,i+str1.length()).equals(str1)){
                return 1;
            }
        }
        return 0;
    }
}
