import java.util.Scanner;

public class Main {
    /**
     * 정렬 : 20291
     * 이분탐색 : 7795, 1920, 1764, 3273, 10816, 2470
     * 매개변수탐색(이분탐색 응용) : 2805, 2110, 1654, 2512, 2343, 6236, 13702, 17266, 1300(고), 1637(고)
     * 투포인터 : 1806,
     */

    static int[] numbers;
    static int n;
    static int value;

    static void input() {
        var sc = new Scanner(System.in);
        var sizeInputs = sc.nextLine().split(" ");
        n = Integer.parseInt(sizeInputs[0]);
        value = Integer.parseInt(sizeInputs[1]);
        numbers = new int[n];
        var numberInputs = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }
    }

    static void solution() {
        var minLength = Integer.MAX_VALUE;
        var right = 0;
        var sum = numbers[0];
        for (int i = 0; i < n; i++) {
            while (right < n - 1 && sum < value) {
                right++;
                sum += numbers[right];
            }
            if (sum >= value) {
                minLength = Math.min(right - i + 1, minLength);
            }
            sum -= numbers[i];
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
