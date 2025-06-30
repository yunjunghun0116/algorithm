import java.util.*;

public class  Main {
    static int N, A, B, C;
    static Map<Integer, List<Edge>> edgeMap = new HashMap<>();

    public static void main(String[] args) {
        initialize();
        int result = solve();
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        String[] abcInput = sc.nextLine().split(" ");
        A = Integer.parseInt(abcInput[0]);
        B = Integer.parseInt(abcInput[1]);
        C = Integer.parseInt(abcInput[2]);

        int m = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= N; i++) {
            edgeMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edgeInput = sc.nextLine().split(" ");
            int s = Integer.parseInt(edgeInput[0]);
            int e = Integer.parseInt(edgeInput[1]);
            int v = Integer.parseInt(edgeInput[2]);

            List<Edge> sEdges = edgeMap.get(s);
            sEdges.add(new Edge(e, v));
            edgeMap.put(s, sEdges);

            List<Edge> eEdges = edgeMap.get(e);
            eEdges.add(new Edge(s, v));
            edgeMap.put(e, eEdges);
        }
    }

    public static int solve() {
        int resultNum = 0;
        int maxDist = 0;

        int[] aDist = getDist(A);
        int[] bDist = getDist(B);
        int[] cDist = getDist(C);
        for (int i = 1; i <= N; i++) {
            int abMin = Math.min(aDist[i], bDist[i]);
            int abcMin = Math.min(abMin, cDist[i]);

            if (abcMin > maxDist) {
                resultNum = i;
                maxDist = abcMin;
            }
        }

        return resultNum;
    }

    public static int[] getDist(int start) {
        int[] dist = new int[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < N + 1; i++) {
            if (i == start) continue;
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            List<Edge> edges = edgeMap.get(curr.dest);

            for (Edge edge : edges) {
                if (dist[edge.dest] > dist[curr.dest] + edge.cost) {
                    dist[edge.dest] = dist[curr.dest] + edge.cost;
                    pq.add(new Edge(edge.dest, dist[edge.dest]));
                }
            }
        }

        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
