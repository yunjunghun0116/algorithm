public class problem3 {

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int resultLength = number.length() - k;
        int startIndex = 0;

        while (answer.length() < resultLength) {
            int maxValue = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int i = startIndex; i <= number.length() - (resultLength - answer.length()); i++) {
                int value = Integer.parseInt(String.valueOf(number.charAt(i)));
                if(value == 9){
                    maxIndex = i;
                    break;
                }
                if (value > maxValue) {
                    maxIndex = i;
                    maxValue = value;
                }
            }
            answer.append(number.charAt(maxIndex));
            startIndex = maxIndex +1;
        }
        return answer.toString();
    }
}
