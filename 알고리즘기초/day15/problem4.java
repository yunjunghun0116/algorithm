public class problem4 {
    public int solution(int[] num_list) {
        int answer = 0;
        if(num_list.length == 0) return answer;
        if(num_list.length>=11){
            for(int i = 0; i < num_list.length; i++){
                answer+=num_list[i];
            }
            return answer;
        }
        answer = 1;
        for(int num : num_list){
            answer*=num;
        }
        return answer;
    }
}
