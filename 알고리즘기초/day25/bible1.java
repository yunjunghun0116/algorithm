public class bible1 {

    public int solution(String A, String B) {
        return Math.min(getLeftCount(A, B), getRightCount(A, B));
    }

    public int getLeftCount(String A, String B) {
        int answer = 0;
        String currentStr = A;
        for (int i = 0; i < A.length(); i++) {
            if (currentStr.equals(B)) return answer;
            answer++;
            currentStr = currentStr.substring(1) + currentStr.charAt(0);
        }
        return -1;
    }

    public int getRightCount(String A, String B) {
        int answer = 0;
        String currentStr = A;
        for (int i = 0; i < A.length(); i++) {
            if (currentStr.equals(B)) return answer;
            answer++;
            currentStr = currentStr.charAt(currentStr.length() - 1) + currentStr.substring(0, currentStr.length() - 1);
        }
        return -1;
    }
}
