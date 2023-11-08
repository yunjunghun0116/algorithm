public class problem4 {
    public int[] solution(int start, int end_num) {
        int[] answer = new int[start-end_num+1];
        int number = start;
        for(int i = 0; i < answer.length; i++){
            answer[i] = number--;
        }
        return answer;
    }
}
