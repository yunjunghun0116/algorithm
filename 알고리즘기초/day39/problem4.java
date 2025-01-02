import java.util.*;

public class problem4 {
    public static void main(String[] args) {
        int result = solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
        System.out.println(result);
    }

    public static int solution(int[][] targets) {
        List<int[]> targetList = new ArrayList<>();
        targetList.addAll(Arrays.asList(targets));

        List<int[]> areaList = new ArrayList<>();
        targetList.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for (int[] target : targetList) {
            if (areaList.isEmpty()) {
                areaList.add(target);
                continue;
            }
            boolean find = false;
            for (int i = 0; i < areaList.size(); i++) {
                int[] area = areaList.get(i);
                if (target[1] > area[0]) {
                    areaList.remove(i);
                    areaList.add(new int[]{target[0] < area[0]?area[0]:target[0], target[1]});
                    find = true;
                    break;
                }
            }
            if (!find) {
                areaList.add(target);
            }
        }
        return areaList.size();
    }
}
