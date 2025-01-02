public class bible3 {
    public int solution(int slice, int n) {
        int answer = 1;
        while (slice * answer < n) {
            answer++;
        }
        return answer;
    }
}
