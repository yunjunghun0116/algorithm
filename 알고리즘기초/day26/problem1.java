import java.util.*;

// [PCCP 기출문제] 2번 / 석유 시추 80점(정확성 60 + 효율성 20) - 효율성 개선해야할것같음
public class problem1 {

    public static void main(String[] args) {
        int[][] land = new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println("solution(land) = " + solution(land));
    }

    public static int solution(int[][] land) {
        // Stack<int[]> landBFSStack = new Stack<>(); DFS
        Queue<int[]> landBFSQueue = new LinkedList<>(); // BFS
        boolean[][] visited = new boolean[land.length][land[0].length];
        String[][] result = new String[land.length][land[0].length];
        int[][] points = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        Map<String, Integer> sizeMap = new HashMap<>();
        Map<String, int[][]> relatedPlaceMap = new HashMap<>();
        char startKey = 'A';
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    String key = startKey + "";
                    ArrayList<int[]> visitedPlaceList = new ArrayList();
                    int size = 0;
                    int[] firstPlace = new int[]{i, j};

                    landBFSQueue.add(firstPlace);
                    visitedPlaceList.add(firstPlace);
                    visited[i][j] = true;
                    result[i][j] = key;

                    while (!landBFSQueue.isEmpty()) {
                        int[] place = landBFSQueue.remove();
                        size++;
                        for (int[] point : points) {
                            int dx = place[0] + point[0];
                            int dy = place[1] + point[1];
                            if (dx < 0 || dx >= land.length || dy < 0 || dy >= land[0].length) continue;
                            if (land[dx][dy] == 1 && !visited[dx][dy]) {
                                int[] secondPlace = new int[]{dx, dy};

                                landBFSQueue.add(secondPlace);
                                visitedPlaceList.add(secondPlace);
                                visited[dx][dy] = true;
                                result[dx][dy] = key;
                            }
                        }
                    }

                    sizeMap.put(key, size);
                    int[][] list = new int[visitedPlaceList.size()][2];

                    for (int k = 0; k < visitedPlaceList.size(); k++) {
                        list[k] = visitedPlaceList.get(k);
                    }
                    relatedPlaceMap.put(key, list);

                    startKey++;
                }
            }
        }
        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            int size = 0;
            ArrayList<String> visitedKeyList = new ArrayList();

            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1) {
                    if (visitedKeyList.contains(result[j][i])) continue;
                    visitedKeyList.add(result[j][i]);
                }
            }
            for (String key : visitedKeyList) {
                int keySize = sizeMap.get(key);
                size += keySize;
            }

            answer = Math.max(answer, size);
        }
        return answer;
    }
}
