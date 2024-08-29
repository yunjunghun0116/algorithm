import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 정렬 : 20291
     * 이분탐색 : 7795, 1920, 1764, 3273, 10816, 2470
     * 매개변수탐색(이분탐색 응용) : 2805, 2110, 1654, 2512, 2343, 6236, 13702, 17266, 1300(고), 1637(고)
     * 투포인터 : 1806, 2003, 2559, 15565, 11728, 2230
     */

    static int[] numbers;
    static int n;
    static int value;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        numbers = new int[n];

        var numberInputs = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }
    }

    static void solution() {
        Arrays.sort(numbers);

        var right = n - 1;
        var leftResult = 0;
        var rightResult = n - 1;
        var minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            while (right > i + 1 && Math.abs(numbers[i] + numbers[right - 1]) < Math.abs(numbers[i] + numbers[right])) {
                right--;
            }
            while (right < n - 1 && Math.abs(numbers[i] + numbers[right]) > Math.abs(numbers[i] + numbers[right + 1])) {
                right++;
            }
            var sum = numbers[i] + numbers[right];
            if (i < right && Math.abs(sum) < minDifference) {
                leftResult = numbers[i];
                rightResult = numbers[right];
                minDifference = Math.abs(sum);
            }
        }

        System.out.println(leftResult + " " + rightResult);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
