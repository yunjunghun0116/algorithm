import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int[] numbers, nge;

    public static void main(String[] args) {
        initialize();
        solve();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(nge[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        numbers = new int[n];
        nge = new int[n];

        String[] numberInput = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }
    }

    public static void solve() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                nge[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }
    }
}
