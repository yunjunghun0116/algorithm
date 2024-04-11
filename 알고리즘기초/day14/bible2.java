public class bible2 {
    public static void main(String[] args)  {
        System.out.println(solution(99999));
    }

    public static int solution(int order) {
        int answer = 0;
        String str = String.valueOf(order);
        for (int i = 0; i < str.length(); i++) {
            int value = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(value == 0) continue;
            if (value % 3 == 0) {
                answer++;
            }
        }
        return answer;
    }
}
