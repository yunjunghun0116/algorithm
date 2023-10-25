import java.util.*;

public class more_problem {
    public int solution(int a, int b, int c, int d) {
        int[] numList = {a, b, c, d};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int number : numList) {
            if (hashMap.containsKey(number)) {
                hashMap.put(number, hashMap.get(number) + 1);
                continue;
            }
            hashMap.put(number, 1);
        }

        int sameCount = hashMap.keySet().size();
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        switch (sameCount) {
            case 1:
                return 1111 * a;
            case 2: {
                if (hashMap.containsValue(2)) {
                    Object[] numberArr = hashMap.keySet().toArray();
                    int sum = (int) numberArr[0] + (int) numberArr[1];
                    int sub = (int) numberArr[0] > (int) numberArr[1] ? (int) numberArr[0] - (int) numberArr[1] : (int) numberArr[1] - (int) numberArr[0];
                    return sum * sub;
                }
                int threeNum = 0;
                int oneNum = 0;
                for (Map.Entry<Integer, Integer> entry : entrySet) {
                    if (entry.getValue() == 3) {
                        threeNum = entry.getKey();
                        continue;
                    }
                    oneNum = entry.getKey();
                }
                return (int) Math.pow((10 * threeNum + oneNum), 2);
            }
            case 3: {
                int result = 1;
                for (Map.Entry<Integer, Integer> entry : entrySet) {
                    if (entry.getValue() == 2) {
                        continue;
                    }
                    result *= entry.getKey();
                }
                return result;
            }
            default:
                int min = 6;
                for (Map.Entry<Integer, Integer> entry : entrySet) {
                    int number = entry.getKey();
                    if (min <= number) continue;
                    min = number;
                }
                return min;

        }
    }
}
