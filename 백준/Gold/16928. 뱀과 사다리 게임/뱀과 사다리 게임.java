import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] board = new int[101];
    static int[] count = new int[101];

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] cntInput = sc.nextLine().split(" ");
        int totalCnt = Integer.parseInt(cntInput[0]) + Integer.parseInt(cntInput[1]);

        for (int i = 0; i < totalCnt; i++) {
            String[] moveInput = sc.nextLine().split(" ");
            int s = Integer.parseInt(moveInput[0]);
            int e = Integer.parseInt(moveInput[1]);

            board[s] = e;
        }

        for (int i = 0; i < 101; i++) {
            count[i] = Integer.MAX_VALUE;
        }
    }

    public static void solve() {
        // dest, count 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 6; i >= 1; i--) {
                int next = curr[0] + i;
                int nextCnt = curr[1] + 1;
                if (next > 100) continue;
                while (board[next] != 0) {
                    next = board[next];
                }
                if (count[next] <= nextCnt) continue;
                if (board[next] == 0) {
                    count[next] = nextCnt;
                    queue.add(new int[]{next, nextCnt});
                }
            }
        }

        System.out.println(count[100]);
    }
}
