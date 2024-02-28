public class problem4 {

    public static void main(String[] args) {
        System.out.println(getStringByNumber(16, 1));
    }

    static String[] charStr = new String[]{"A", "B", "C", "D", "E", "F"};

    public static String solution(int n, int t, int m, int p) {
        // n : 몇진수인지
        // t : 몇개를 말해야 하는지
        // m : 몇명인지
        // p : 몇번째인지

        StringBuilder answer = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int number = 0;
        while (answer.length() < t * m) {
            answer.append(getStringByNumber(n, number));
            number++;
        }
        int index = p - 1;
        for (int i = 0; i < t; i++) {
            result.append(answer.charAt(m * i + index));
        }

        return result.toString();
    }

    public static String getStringByNumber(int n, int number) {
        if (number == 0) return "0";
        // number 를 n 으로 값을 매기기
        StringBuilder answer = new StringBuilder();

        int i = 0;
        while (Math.pow(n, i) <= number) {
            i++;
        }
        i--;
        while (i >= 0) {
            int value = (int) (number / Math.pow(n, i));
            if (value >= 10) {
                answer.append(charStr[value - 10]);
            } else {
                answer.append(value);
            }
            number = (int) (number % Math.pow(n, i));
            i--;
        }

        return answer.toString();
    }
}
