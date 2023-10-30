import java.math.BigDecimal;

public class bible4 {

    public static void main(String[] args) {

        System.out.println(solution(30, 15));
    }

    public static long solution(int balls, int share) {
        if (balls == share || share == 0) return 1;
        int minCount = share > (balls - share) ? (balls - share) : share;
        long answer = 1;
        for (int i = 0; i < minCount; i++) {
            answer *= (balls - i);
            answer /= (i + 1);
        }

        return answer;
    }

    public static int solution2(int balls, int share) {
        if (balls == share || share == 0) return 1;
        if (share == 1) return balls;
        BigDecimal division = BigDecimal.ONE;
        int minCount = share > (balls - share) ? (balls - share) : share;
        for (int i = 0; i < minCount; i++) {
            division = division.multiply(new BigDecimal(balls - i));
        }
        for (int i = 0; i < minCount; i++) {
            division = division.divide(new BigDecimal(minCount - i));
        }

        return division.intValue();
    }

}
