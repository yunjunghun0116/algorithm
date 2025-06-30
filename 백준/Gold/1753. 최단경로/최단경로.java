import java.util.*;

public class Main {
    static Map<Integer, List<Edge>> edgeMap = new HashMap<>();
    static PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
    static int[] dist;
    static int V, START;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        V = Integer.parseInt(sizeInput[0]);
        int edgeCnt = Integer.parseInt(sizeInput[1]);
        START = Integer.parseInt(sc.nextLine());
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            if (i == START) continue;
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= V; i++) {
            edgeMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            String[] edgeInput = sc.nextLine().split(" ");
            int s = Integer.parseInt(edgeInput[0]);
            int e = Integer.parseInt(edgeInput[1]);
            int v = Integer.parseInt(edgeInput[2]);


            List<Edge> edges = edgeMap.get(s);
            edges.add(new Edge(e, v));
            edgeMap.put(s, edges);
        }
    }

    public static void solve() {
         edgePQ.add(new Edge(START, 0));

        while (!edgePQ.isEmpty()) {
            Edge edge = edgePQ.poll();
            if (dist[edge.dest] < edge.cost) continue;
            
            dist[edge.dest] = edge.cost;

            List<Edge> edges = edgeMap.get(edge.dest);
            for (Edge nextEdge : edges) {
                if (dist[nextEdge.dest] > dist[edge.dest] + nextEdge.cost) {
                    dist[nextEdge.dest] = dist[edge.dest] + nextEdge.cost;
                    edgePQ.add(new Edge(nextEdge.dest, dist[edge.dest] + nextEdge.cost));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}
