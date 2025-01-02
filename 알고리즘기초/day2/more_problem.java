import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class more_problem {
    // 정수를 나선형으로 배치하기
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[][] result = solution(n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(result[i][j] + " ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);

    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int number = 1;
        int cycleCount = (n % 2 == 0 ? n / 2 : (n / 2) + 1);
        int currentX;
        int currentY;

        for (int i = 0; i < cycleCount; i++) {

            currentX = i;
            currentY = i;
            // y 증가
            while (currentY < n - i) {
                if (answer[currentX][currentY] == 0) {
                    answer[currentX][currentY] = number++;
                }
                if (currentY == n - i - 1) {
                    break;
                }
                currentY++;
            }
            // x 증가
            while (currentX < n - i) {
                if (answer[currentX][currentY] == 0) {
                    answer[currentX][currentY] = number++;
                }
                if (currentX == n - i - 1) {
                    break;
                }
                currentX++;
            }
            // y 감소
            while (currentY >= i) {
                if (answer[currentX][currentY] == 0) {
                    answer[currentX][currentY] = number++;
                }
                if (currentY == i) {
                    break;
                }
                currentY--;
            }
            // x 감소
            while (currentX >= i) {
                if (answer[currentX][currentY] == 0) {
                    answer[currentX][currentY] = number++;
                }
                if (currentX == i) {
                    break;
                }
                currentX--;
            }
        }

        return answer;
    }
}
