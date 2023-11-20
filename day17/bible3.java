public class bible3 {
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        for(int i = 0; i < str.length(); i++){
            answer+=Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        return answer;
    }
}
