import java.util.Scanner;

public class Main {
    public static String code;
    public static int[] dp;

    public static void main(String[] args) {
        initialize();
        int result = find();
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        code = sc.nextLine();
        dp = new int[code.length()];
    }

    public static int find() {
        if (!canUseNumber(0)) return 0;
        if (code.length() == 1) return 1;

        dp[0] = 1;
        if (canUseNumber(1)) {
            dp[1] = dp[0];
        }
        if (canUseTwoNumber(1)) {
            dp[1] = dp[1] + 1;
        }
        for (int i = 2; i < code.length(); i++) {
            if (canUseNumber(i)) {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }
            if (canUseTwoNumber(i)) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }
        return dp[code.length() - 1];
    }

    public static boolean canUseNumber(int index) {
        int num;
        if (index + 1 == code.length()) {
            num = Integer.parseInt(code.substring(index));
        } else {
            num = Integer.parseInt(code.substring(index, index + 1));
        }

        return num > 0 && num <= 26;
    }

    public static boolean canUseTwoNumber(int index) {
        int num;
        if (index + 1 == code.length()) {
            num = Integer.parseInt(code.substring(index - 1));
        } else {
            num = Integer.parseInt(code.substring(index - 1, index + 1));
        }
        return num > 9 && num <= 26;
    }
}
