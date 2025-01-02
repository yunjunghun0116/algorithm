import java.util.*;

class Solution {
    public int solution(int[][] land) {
        Map<Integer, Set<Integer>> connectedOilMap = new HashMap<>();
        Map<Integer, Integer> oilValueMap = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        int index = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int count = 0;
                    Set<Integer> set = new HashSet<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] landPosition = queue.poll();
                        set.add(landPosition[1]);

                        count++;

                        for (int k = 0; k < 4; k++) {
                            int nextI = landPosition[0] + dx[k];
                            int nextJ = landPosition[1] + dy[k];
                            if (nextI < 0 || nextI >= land.length || nextJ < 0 || nextJ >= land[0].length) continue;
                            if (land[nextI][nextJ] == 1 && !visited[nextI][nextJ]) {
                                queue.add(new int[]{nextI, nextJ});
                                visited[nextI][nextJ] = true;
                            }
                        }
                    }
                    int key = index++;
                    connectedOilMap.put(key, set);
                    oilValueMap.put(key, count);
                }
            }
        }


        Map<Integer, Set<Integer>> reversedOilMap = new HashMap<>();

        for (Map.Entry<Integer, Set<Integer>> entry : connectedOilMap.entrySet()) {

            int key = entry.getKey();
            Set<Integer> jList = entry.getValue();

            for (int j : jList) {
                if (reversedOilMap.containsKey(j)) {
                    Set<Integer> oilSet = reversedOilMap.get(j);
                    oilSet.add(key);
                    reversedOilMap.put(j, oilSet);
                    continue;
                }
                Set<Integer> oilSet = new HashSet<>();
                oilSet.add(key);
                reversedOilMap.put(j, oilSet);
            }
        }

        int maxValue = 0;
        for (Map.Entry<Integer, Set<Integer> > entry : reversedOilMap.entrySet()) {
            Set<Integer> oilList = entry.getValue();
            int value = 0;
            for (int oil : oilList) {
                value += oilValueMap.get(oil);
            }
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }
}