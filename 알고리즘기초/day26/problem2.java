public class problem2 {
    public static void main(String[] args) {
        int[] result = solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int index = 0;
        for (int[] ball : balls) {
            int ballX = ball[0];
            int ballY = ball[1];
            int result = Integer.MAX_VALUE;
            // x 이동시 y가 겹치면 안돼, y 이동시 x가 겹치면 안돼
            // 대칭이동해서 두 점을 이었을때 대칭이동한 공이 존재하면 안되기에 그 경우를 빼준것
            // 좌 -> 왼쪽으로 대칭 이동시 왼쪽 벽에 맞기 전에 공에 먼저 맞음
            if (!(startY == ballY && startX >= ballX)) {
                result = Math.min(result, getValue(startX, startY, (-1) * ballX, ballY));
            }
            // 우 -> 오른쪽으로 대칭이동시 벽에 맞기도 전에 공에 먼저 맞음
            if (!(startY == ballY && startX <= ballX)) {
                result = Math.min(result, getValue(startX, startY, 2 * m - ballX, ballY));
            }
            //상 -> 같은 x에서 공이 나보다 위에있으면 벽에 맞기도 전에 공에 먼저 맞음
            if (!(startX == ballX && startY <= ballY)) {
                result = Math.min(result, getValue(startX, startY, ballX, 2 * n - ballY));
            }
            //하
            if (!(startX == ballX && startY >= ballY)) {
                result = Math.min(result, getValue(startX, startY, ballX, (-1) * ballY));

            }

            answer[index++] = result;
        }
        return answer;
    }

    public static int getValue(int x, int y, int a, int b) {
        return (int) (Math.pow((x - a), 2) + Math.pow((y - b), 2));
    }
}
