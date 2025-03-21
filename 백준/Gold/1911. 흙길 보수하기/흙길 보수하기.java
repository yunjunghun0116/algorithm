import java.util.*;

public class Main {
    public static int N, L;
    public static List<int[]> waters = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        N = Integer.parseInt(sizeInput[0]);
        L = Integer.parseInt(sizeInput[1]);

        for (int i = 0; i < N; i++) {
            String[] waterInput = sc.nextLine().split(" ");
            int start = Integer.parseInt(waterInput[0]);
            int end = Integer.parseInt(waterInput[1]);

            waters.add(new int[]{start, end});
        }

        Collections.sort(waters, (a, b) -> a[0] - b[0]);
    }

    public static void solve() {
        Queue<int[]> waterQueue = new LinkedList<>();

        for (int[] water : waters) {
            waterQueue.add(water);
        }
        int cnt = 0;

        while (!waterQueue.isEmpty()) {
            int[] water = waterQueue.poll();

            while (!waterQueue.isEmpty() && canChangeEnd(water[0], water[1], waterQueue.peek()[0])) {
                int[] nextWater = waterQueue.poll();
                water[1] = nextWater[1];
            }

            int length = water[1] - water[0];
            cnt += length / L;
            int leavedLength = length % L;

            if (leavedLength > 0) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean canChangeEnd(int start, int end, int nextStart) {
        int length = end - start;
        if (length % L == 0) return false;
        int leavedStart = end - (length % L);
        return leavedStart + L >= nextStart;
    }
}
