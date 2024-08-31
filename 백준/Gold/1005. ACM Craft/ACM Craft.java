import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /**
     * 정렬 : 20291
     * 이분탐색 : 7795, 1920, 1764, 3273, 10816, 2470
     * 매개변수탐색(이분탐색 응용) : 2805, 2110, 1654, 2512, 2343, 6236, 13702, 17266, 1300(고), 1637(고)
     * 투포인터 : 1806, 2003, 2559, 15565, 11728, 2230, 13144, 1253, 2473, 16472
     * 그래프 탐색 : 1260, 2667, 1012, 11724, 4963, 3184, 2606, 11403, 11725, 2251, 14502, 2178, 1697, 1387, 5567, 3055, 7569, 2644
     * 트리: 11725, 1991, 5639, 15900, 20364, 3584, 1240, 9489, 1068, 15681, 14267,
     * 위상정렬 : 2252, 1516, 2056, 2637
     */

    static int[] inDegrees;
    static int[] times;
    static int[] maxTimes;
    static Map<Integer, List<Integer>> destMap;
    static int n;
    static int value;

    static void input() {
        var sc = new Scanner(System.in);
        var testCases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCases; i++) {
            destMap = new HashMap<>();

            var cntInputs = sc.nextLine().split(" ");
            n = Integer.parseInt(cntInputs[0]);
            inDegrees = new int[n + 1];
            times = new int[n + 1];
            maxTimes = new int[n + 1];

            var timeInputs = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                var time = Integer.parseInt(timeInputs[j]);
                times[j + 1] = time;
                maxTimes[j + 1] = time;
            }

            var lines = Integer.parseInt(cntInputs[1]);
            for (int j = 0; j < lines; j++) {
                var edge = sc.nextLine().split(" ");
                var start = Integer.parseInt(edge[0]);
                var end = Integer.parseInt(edge[1]);

                var destList = destMap.getOrDefault(start, new ArrayList<>());
                destList.add(end);
                destMap.put(start, destList);

                inDegrees[end]++;
            }

            var dest = Integer.parseInt(sc.nextLine());

            solution(dest);
        }
    }

    static void solution(int dest) {
        // 위상정렬한다.
        // 앞에서부터 뒤에 있는놈들에 대해서 Max 를 수행해준다.
        // 원하는 곳의 최종 시간을 구한다.
        // 위상정렬 : inDegree 가 0인것에 대해서 삭제
        var sortedList = new ArrayList<Integer>();
        var queue = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            var start = queue.poll();
            sortedList.add(start);
            inDegrees[start] = -1;
            var destList = destMap.getOrDefault(start, new ArrayList<>());
            for (int end : destList) {
                inDegrees[end]--;
                if (inDegrees[end] == 0) {
                    queue.add(end);
                }
            }
        }

        for (var node : sortedList) {
            var destList = destMap.getOrDefault(node, new ArrayList<>());
            for (int end : destList) {
                maxTimes[end] = Math.max(maxTimes[node] + times[end], maxTimes[end]);
            }
        }

        System.out.println(maxTimes[dest]);
    }

    public static void main(String[] args) {
        input();
    }
}
