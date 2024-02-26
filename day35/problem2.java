import java.util.*;

public class problem2 {

    static int max_sheep = Integer.MIN_VALUE;
    static Map<Integer, List<Integer>> edgeMap = new HashMap<>();

    static int[] sheepInfo;

    public static void main(String[] args) {
        int result = solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9},});
        System.out.println(result);
    }

    public static int solution(int[] info, int[][] edges) {
        sheepInfo = info;

        for (int[] edge : edges) {
            if (edgeMap.containsKey(edge[0])) {
                List<Integer> dist = edgeMap.get(edge[0]);
                dist.add(edge[1]);
                edgeMap.put(edge[0], dist);
                continue;
            }
            List<Integer> dist = new ArrayList<>();
            dist.add(edge[1]);
            edgeMap.put(edge[0], dist);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        find(0, 0, 0,list);

        return max_sheep;
    }

    public static void find(int start, int sheepCount, int wolfCount,List<Integer> dist) {
        System.out.println(start);
        if (sheepInfo[start] == 0) {
            sheepCount++;
        } else {
            wolfCount++;
        }
        if (wolfCount >= sheepCount) return;
        max_sheep = Math.max(max_sheep, sheepCount);

        List<Integer> list = new ArrayList<>();
        list.addAll(dist);
        list.remove(Integer.valueOf(start));

        if(edgeMap.containsKey(start)){
            List<Integer> dst = edgeMap.get(start);
            list.addAll(dst);
        }

        for (int distNum : dist) {
            find(distNum, sheepCount, wolfCount,list);
        }
    }
}
