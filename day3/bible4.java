public class bible4 {
    public int[] solution(int n) {
        int arraySize = (n+1)/2;
        int[] answer = new int[arraySize];
        for(int i = 0; 2*i+1 <= n; i++){
            answer[i] = 2*i+1;
        }
        return answer;
    }
}
