import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class bible2 {
    // 직관적인 배열을 통한 풀이
    public static int solution(int[] array) {
        int[] result = new int[1001];
        for (int number : array) {
            result[number] += 1;
        }
        int max = -1;
        int maxCount = -1;
        int maxIndex = -1;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                maxIndex = i;
                maxCount = 1;
                continue;
            }
            if (result[i] == max) {
                maxCount++;
            }
        }
        return maxCount > 1 ? -1 : maxIndex;
    }

    // Map을 사용한 풀이
    public static int solution2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : array) {
            if (map.containsKey(number)) {
                int count = map.get(number);
                map.replace(number, count + 1);
                continue;
            }
            map.put(number, 1);
        }
        Set<Map.Entry<Integer, Integer>> result = map.entrySet();
        int maxCount = -1;
        int answer = -1;
        for (Map.Entry<Integer, Integer> entry : result) {
            int number = entry.getKey();
            int count = entry.getValue();
            if (count < maxCount) continue;
            if (count > maxCount) {
                maxCount = count;
                answer = number;
                continue;
            }
            if (count == maxCount) {
                answer = -1;
            }
        }
        return answer;

    }
}
