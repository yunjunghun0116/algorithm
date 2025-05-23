import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static PriorityQueue<Integer> burgerQueue = new PriorityQueue<>((a, b) -> a - b);
    static Queue<Integer> personQueue = new LinkedList<>();
    static int N, K;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        K = Integer.parseInt(sizeInput[1]);

        String input = sc.nextLine();

        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'H') {
                burgerQueue.add(i);
                continue;
            }
            personQueue.add(i);
        }
    }

    public static void solve() {
        int cnt = 0;
        Queue<Integer> tempList = new LinkedList<>();

        while (!personQueue.isEmpty()) {
            int personIndex = personQueue.poll();

            while (!burgerQueue.isEmpty() && burgerQueue.peek() <= personIndex + K) {
                int burgerIndex = burgerQueue.poll();
                if (Math.abs(burgerIndex - personIndex) <= K) {
                    cnt++;
                    break;
                }
                if (burgerIndex >= personIndex - K) {
                    tempList.add(burgerIndex);
                }
            }

            while (!tempList.isEmpty()) {
                burgerQueue.add(tempList.poll());
            }
        }

        System.out.println(cnt);
    }
}
