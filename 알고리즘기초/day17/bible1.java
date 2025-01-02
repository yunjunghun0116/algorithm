public class bible1 {
    public int solution(int num, int k) {
        String str = String.valueOf(num);
        for(int i = 0;i < str.length(); i++){
            int value = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(value == k){
                return i+1;
            }
        }
        return -1;
    }
}
