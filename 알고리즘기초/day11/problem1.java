public class problem1 {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        int[] small = new int[26];
        int[] big = new int[26];
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c>=97){
                small[c-97] = small[c-97]+1;
                continue;
            }
            big[c-65] = big[c-65]+1;
        }
        System.arraycopy(big,0,answer,0,big.length);
        System.arraycopy(small,0,answer,big.length,small.length);
        return answer;
    }
}
