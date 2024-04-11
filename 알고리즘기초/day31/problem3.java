import java.util.*;

public class problem3 {

    public static void main(String[] args) {
        int result = solution(16, new int[]{9}, 2);
        System.out.println(result);
    }

    public static int solution(int n, int[] stations, int w) {
        boolean[] area = new boolean[n];

        for (int index : stations) {
            int position = index - 1;
            int start = Math.max(position - w, 0);
            int end = Math.min(position + w, n - 1);

            for (int i = start; i <= end; i++) {
                area[i] = true;
            }
        }

        List<Integer> sizeList = new ArrayList<>();

        // 안닿는 구역의 시작과 끝을 찾는다
        boolean findStart = false;
        int start = 0;
        int end;
        for (int i = 0; i < n; i++) {
            if (!area[i]) {
                if (findStart) {
                    continue;
                }
                start = i;
                findStart = true;
                continue;
            }
            if (findStart) {
                end = i - 1;
                sizeList.add(end - start + 1);
                findStart = false;
            }
        }

        if(findStart){
            end = n-1;
            sizeList.add(end - start + 1);
        }

        // 구역의 사이즈를 구해서 필요한 갯수를 각각 구한다.
        int answer = 0;
        for (int size : sizeList) {
            int divider = w * 2 + 1;
            if (size % divider == 0) {
                answer += size / divider;
                continue;
            }
            answer += size / divider;
            answer += 1;
        }

        return answer;
    }
}
