import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int S, E;
    static boolean[] visited = new boolean[1000001];

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        S = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
    }

    public static void solve() {
        Queue<int[]> queue = new LinkedList<>();//dest, cost

        queue.add(new int[]{S, 0});
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int dest = data[0];
            int cost = data[1];
            if (dest < 0 || dest >= 1000001) continue;
            if (visited[dest]) continue;
            visited[dest] = true;
            if (dest == E) {
                System.out.println(cost);
                return;
            }
            queue.add(new int[]{dest + 1, cost + 1});
            queue.add(new int[]{dest - 1, cost + 1});
            queue.add(new int[]{dest * 2, cost + 1});
        }
    }
}
