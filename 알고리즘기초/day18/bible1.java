public class bible1 {
    public int solution(String str1, String str2) {
        for(int i = 0;i<=str1.length()-str2.length(); i++){
            if(str1.substring(i,i+str2.length()).equals(str2)){
                return 1;
            }
        }
        return 2;
    }
}
