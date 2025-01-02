import java.util.*;

class Solution {
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
        Queue<int[]> queue = new LinkedList<>();//new PriorityQueue<>(Comparator.comparing((int[] point)->point[1]));

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