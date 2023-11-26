public class bible3 {
    public int solution(int[] sides) {
        int answer = 0;
        //가장긴변 < 나머지 두변의 길이
        //1. sides중 가장긴변이 있는경우
        int a = Math.max(sides[0], sides[1]);
        int b = Math.min(sides[0], sides[1]);
        for (int i = 1; i < a; i++) {
            if (a < i + b) {
                answer++;
            }
        }
        //2. 나머지가 가장긴변인 경우
        for (int i = Math.max(sides[0], sides[1]); i < (sides[0]+sides[1]); i++) {
            answer++;
        }
        return answer;
    }
}
