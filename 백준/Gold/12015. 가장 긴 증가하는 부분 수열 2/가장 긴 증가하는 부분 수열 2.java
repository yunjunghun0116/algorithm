import java.util.Scanner;

public class Main {
    public static int[] array;
    public static int[] dp;
    public static int lastIndex = 0;

    public static void main(String[] args) {
        initialize();
        solve();
        System.out.println(lastIndex + 1);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        array = new int[n];
        dp = new int[n];
        String[] arrayInput = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(arrayInput[i]);
        }
    }

    public static void solve() {
        dp[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            setNumber(array[i]);
        }
    }

    public static void setNumber(int number) {
        if (dp[lastIndex] < number) {
            dp[++lastIndex] = number;
            return;
        }

        int left = 0;
        int right = lastIndex;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            int num = dp[mid];
            if (num == number) {
                return;
            }
            if (num < number) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }

        if (dp[left] > number) {
            dp[left] = number;
        }
    }
}
