import java.util.*;

public class problem2 {

    public static void main(String[] args) {
        int[] result = solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}});
        System.out.println("result : " + result[0] + "," + result[1]);
    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        for (int[] row : arr) {
            for (int value : row) {
                if (value == 0) {
                    answer[0]++;
                    continue;
                }
                answer[1]++;
            }
        }
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0, arr.length});
        while (!queue.isEmpty()) {
            int[] position = queue.remove();
            int currentSize = position[2];
            if (currentSize == 1) continue;
            int[] result = check(position[0], position[1], currentSize, arr);
            if (result[1] == 0) {
                int nextSize = currentSize / 2;
                queue.offer(new int[]{position[0], position[1], nextSize});
                queue.offer(new int[]{position[0] + nextSize, position[1], nextSize});
                queue.offer(new int[]{position[0], position[1] + nextSize, nextSize});
                queue.offer(new int[]{position[0] + nextSize, position[1] + nextSize, nextSize});
                continue;
            }
            if (result[0] == 1) {
                answer[1] = answer[1] - result[1];
                continue;
            }
            answer[0] = answer[0] - result[1];

        }

        return answer;
    }

    public static int[] check(int startX, int startY, int size, int[][] arr) {
        System.out.println("args : "+startX+", "+startY +", "+size);
        int checkValue = arr[startX][startY];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[startX + i][startY + j] == checkValue) continue;
                return new int[]{0, 0};
            }
        }

        return new int[]{checkValue, size * size - 1};
    }
}
