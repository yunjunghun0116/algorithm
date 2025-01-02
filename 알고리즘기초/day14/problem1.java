public class problem1 {
    public int solution(int[] num_list) {
        int oddSum = 0;
        int evenSum = 0;
        for(int i =0; i < num_list.length;i++){
            if(i%2 == 0){
                evenSum+=num_list[i];
                continue;
            }
            oddSum+=num_list[i];
        }
        return oddSum>evenSum?oddSum:evenSum;
    }
}
