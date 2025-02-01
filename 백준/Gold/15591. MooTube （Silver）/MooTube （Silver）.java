import java.util.*;

public class Main {
    public static List<int[]>[] graph;
    public static int n, q;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initialize();
        answerRecommend();
        sc.close();
    }

    public static void initialize() {
        String[] sizeInput = sc.nextLine().split(" ");
        n = Integer.parseInt(sizeInput[0]);
        q = Integer.parseInt(sizeInput[1]);

        // 그래프 초기화 (N+1 크기의 리스트 배열)
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 (USADO 값 포함)
        for (int i = 1; i < n; i++) {
            String[] distInput = sc.nextLine().split(" ");
            int s = Integer.parseInt(distInput[0]);
            int e = Integer.parseInt(distInput[1]);
            int dist = Integer.parseInt(distInput[2]);

            graph[s].add(new int[]{e, dist});
            graph[e].add(new int[]{s, dist});
        }
    }

    public static void answerRecommend() {
        for (int i = 0; i < q; i++) {
            String[] questionInput = sc.nextLine().split(" ");
            int distCost = Integer.parseInt(questionInput[0]);
            int videoNumber = Integer.parseInt(questionInput[1]);
            System.out.println(findUSADO(videoNumber, distCost));
        }
    }

    public static int findUSADO(int start, int cost) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int result = 0;

        queue.offer(new int[]{start, Integer.MAX_VALUE});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int minUSADO = current[1];

            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int usado = neighbor[1];

                if (!visited[nextNode]) {
                    int newUSADO = Math.min(minUSADO, usado);
                    if (newUSADO >= cost) {
                        result++;
                        queue.offer(new int[]{nextNode, newUSADO});
                    }
                    visited[nextNode] = true;
                }
            }
        }

        return result;
    }
}
