import java.util.*;

public class Main {
    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] sizeInput = sc.nextLine().split(" ");
            int v = Integer.parseInt(sizeInput[0]);
            int e = Integer.parseInt(sizeInput[1]);
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int j = 1; j <= v; j++) {
                graph.put(j, new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                String[] edgeInput = sc.nextLine().split(" ");
                int start = Integer.parseInt(edgeInput[0]);
                int end = Integer.parseInt(edgeInput[1]);

                List<Integer> startList = graph.get(start);
                startList.add(end);
                graph.put(start, startList);

                List<Integer> endList = graph.get(end);
                endList.add(start);
                graph.put(end, endList);
            }

            boolean result = solve(v, graph);
            if (result) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    public static boolean solve(int v, Map<Integer, List<Integer>> graph) {
        int[] visited = new int[v + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (visited[i] != 0) continue;
            queue.add(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int number = queue.poll();
                int value = visited[number];

                List<Integer> destList = graph.get(number);
                for (int dest : destList) {
                    if (visited[dest] == 0) {
                        visited[dest] = -1 * value;
                        queue.add(dest);
                        continue;
                    }
                    if (visited[dest] == -1 * value) {
                        continue;
                    }
                    return false;
                }
            }

        }
        return true;
    }
}
