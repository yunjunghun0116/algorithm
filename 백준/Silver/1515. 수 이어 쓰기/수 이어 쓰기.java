import java.util.Scanner;

public class Main {
    static String leaveString;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        leaveString = sc.nextLine();
    }

    public static void solve() {
        int number = 0;

        while (!leaveString.isEmpty()) {
            number++;
            String str = String.valueOf(number);
            for (int i = 0; i < str.length(); i++) {
                if (leaveString.isEmpty()) break;
                int n = Integer.parseInt(String.valueOf(str.charAt(i)));
                int firstNum = Integer.parseInt(String.valueOf(leaveString.charAt(0)));
                if (n == firstNum) {
                    leaveString = leaveString.substring(1);
                }
            }
        }

        System.out.println(number);
    }
}
