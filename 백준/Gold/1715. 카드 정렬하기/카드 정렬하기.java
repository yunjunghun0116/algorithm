import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

    public static void main(String[] args) {
        initialize();
        int result = solve();
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(sc.nextLine()));
        }
    }

    public static int solve() {
        int result = 0;
        // 13, 14, 18, 24, 73
        // 18, 24, 27, 73    27
        // 27, 42, 73   69
        // 69, 73    138
        // 142  280
        while (pq.size() > 1) {
            int firstNum = pq.poll();
            int secondNum = pq.poll();
            int sum = firstNum + secondNum;
            result += sum;
            pq.add(sum);
        }
        return result;
    }
}
