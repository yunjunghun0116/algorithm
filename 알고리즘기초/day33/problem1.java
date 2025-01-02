import java.util.*;

public class problem1 {
// https://school.programmers.co.kr/learn/courses/30/lessons/72413
    public static void main(String[] args) {
//        int result1 = solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
//        System.out.println(result1);
//        int result2 = solution(7,3,4,1, new int[][]{{5, 7, 9},{4, 6, 4},{3, 6, 1},{3, 2, 3},{2, 1, 6}});
//        System.out.println(result2);
        int result3 = solution(6, 4, 5, 6, new int[][]{{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}});
        System.out.println(result3);
    }

    static int maxSize;
    static Map<Integer, List<int[]>> roadMap = new HashMap<>();

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        maxSize = n;
        for(int i = 1; i <=n; i++){
            roadMap.put(i, new ArrayList<>());
        }

        for (int[] fare : fares) {
            List<int[]> dst1 = roadMap.get(fare[0]);
            dst1.add(new int[]{fare[1], fare[2]});
            roadMap.put(fare[0], dst1);

            List<int[]> dst2 = roadMap.get(fare[1]);
            dst2.add(new int[]{fare[0], fare[2]});
            roadMap.put(fare[1], dst2);
        }

        int[][] minCostArray = new int[3][n+1];
        minCostArray[0] = getMinCostArray(s);
        minCostArray[1] = getMinCostArray(a);
        minCostArray[2] = getMinCostArray(b);
        int aMinCost = minCostArray[0][a];
        int bMinCost = minCostArray[0][b];

        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int value = minCostArray[0][i] + minCostArray[1][i] + minCostArray[2][i];
            minValue = Math.min(minValue, value);
        }

        return Math.min(aMinCost+bMinCost,minValue);
    }

    public static int[] getMinCostArray(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] point)->point[1]));

        int[] cost = new int[maxSize + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        // 목적지점, value 누적

        queue.add(new int[]{start, 0});
        cost[start] = 0;
        while (!queue.isEmpty()) {
            int[] pollData = queue.poll();
            List<int[]> dstList = roadMap.get(pollData[0]);
            if(dstList==null)  continue;
            if(cost[pollData[0]] < pollData[1]) continue;
            for (int[] dst : dstList) {
                int nextDst = dst[0];
                int nextCost = dst[1] + pollData[1];
                if (cost[nextDst] <= nextCost) continue;
                cost[nextDst] = nextCost;
                queue.add(new int[]{nextDst, nextCost});
            }
        }

        return cost;
    }
}
