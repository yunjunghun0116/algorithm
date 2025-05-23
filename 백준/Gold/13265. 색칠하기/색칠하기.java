import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] sizeInput = sc.nextLine().split(" ");
            int nodeCnt = Integer.parseInt(sizeInput[0]);
            int edgeCnt = Integer.parseInt(sizeInput[1]);

            boolean[][] board = new boolean[nodeCnt + 1][nodeCnt + 1];

            for (int j = 0; j < edgeCnt; j++) {
                String[] edgeInput = sc.nextLine().split(" ");
                int s = Integer.parseInt(edgeInput[0]);
                int e = Integer.parseInt(edgeInput[1]);

                board[s][e] = true;
                board[e][s] = true;
            }

            solve(nodeCnt, board);
        }
    }

    public static void solve(int n, boolean[][] board) {
        int[] visited = new int[n + 1];

        Queue<Integer> nodeQueue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (visited[i] != 0) continue;
            nodeQueue.add(i);
            visited[i] = 1;
            while (!nodeQueue.isEmpty()) {
                int node = nodeQueue.poll();
                int value = visited[node];

                for (int j = 1; j <= n; j++) {
                    if (!board[node][j]) continue;
                    if (visited[j] == value) {
                        System.out.println("impossible");
                        return;
                    }
                    if (visited[j] == 0) {
                        nodeQueue.add(j);
                        visited[j] = value * -1;
                    }
                }
            }
        }

        System.out.println("possible");
    }
}
