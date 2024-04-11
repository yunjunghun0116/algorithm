public class problem3 {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int num : num_list){
            int result = func(num);
            answer+=result;
        }
        return answer;
    }
    public int func(int num){
        int count = 0;
        int number = num;
        while(number>1){
            count++;
            if(number%2==0){
                number = number/2;
                continue;
            }
            number = (number-1)/2;
        }
        return count;
    }
}
