public class bible1 {
    public int solution(int[] array) {
        int answer = 0;
        for(int num:array){
            String str = String.valueOf(num);
            for(int i = 0; i < str.length(); i++){
                if(Integer.parseInt(String.valueOf(str.charAt(i)))==7){
                    answer++;
                }
            }
        }
        return answer;
    }
}
