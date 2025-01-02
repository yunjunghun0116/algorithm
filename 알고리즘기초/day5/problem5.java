public class problem5 {
    public int solution(int[] num_list) {
        String oddNumber = "";
        String evenNumber = "";
        for(int number : num_list){
            if(number%2==0){
                evenNumber+=number;
                continue;
            }
            oddNumber+=number;
        }
        return Integer.parseInt(oddNumber) + Integer.parseInt(evenNumber);
    }
}
