import java.util.stream.Stream;

public class problem2 {

    public static void main(String[] args) {
        System.out.println("solution(0+123) = " + solution("0", "123"));
    }

    public static String solution(String a, String b) {
        boolean upperOne = false;
        String answer = "";
        int minIndex = Math.min(a.length() - 1, b.length() - 1);
        int maxIndex = Math.max(a.length() - 1, b.length() - 1);
        int aMaxIndex = a.length() -1;
        int bMaxIndex = b.length() -1;
        for (int i = 0; i <= minIndex; i++) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(aMaxIndex - i))) + Integer.parseInt(String.valueOf(b.charAt(bMaxIndex - i)));
            if (upperOne) {
                sum += 1;
                upperOne = false;
            }
            if (sum >= 10) {
                upperOne = true;
            }
            answer += String.valueOf(sum % 10);
        }

        for (int i = minIndex+1; i <= maxIndex; i++) {
            int sum = 0;
            if (a.length() > i) {
                sum = Integer.parseInt(String.valueOf(a.charAt(aMaxIndex - i)));
            }
            if (b.length() > i) {
                sum = Integer.parseInt(String.valueOf(b.charAt(bMaxIndex - i)));
            }

            if (upperOne) {
                sum += 1;
                upperOne = false;
            }
            if (sum >= 10) {
                upperOne = true;
            }
            answer += String.valueOf(sum % 10);
        }
        if (upperOne) {
            answer += "1";
        }

        String result = "";
        for (int i = answer.length() - 1; i >= 0; i--) {
            result += answer.charAt(i);
        }
        return result;
    }
}
