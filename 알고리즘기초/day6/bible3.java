public class bible3 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int number : num_list) {
            if (number % 2 == 0) {
                answer[0] = answer[0] + 1;
                continue;
            }
            answer[1] = answer[1] + 1;
        }
        return answer;
    }
}
