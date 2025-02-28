import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    public static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        solve();
        System.out.println(pq.size());
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] timesInput = sc.nextLine().split(" ");
            list.add(new int[]{Integer.parseInt(timesInput[0]), Integer.parseInt(timesInput[1])});
        }

        list.sort((a, b) -> b[1] - a[1]);
    }

    public static void solve() {
        for (int[] time : list) {
            if (!pq.isEmpty() && time[1] <= pq.peek()[0]) {
                int[] polledTime = pq.poll();
                polledTime[0] = time[0];
                pq.add(polledTime);
                continue;
            }
            pq.add(time);
        }
    }
}
