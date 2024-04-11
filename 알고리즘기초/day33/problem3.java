import java.util.*;

public class problem3 {
    public static void main(String[] args) {
        int[] result = solution(4);
    }

    public static int[] solution(int n) {
        int[][] answer = new int[n][n];

        int currentX = 0;
        int currentY = 0;
        int cycleCount = n % 3 == 0 ? n / 3 : n / 3 + 1;
        int writeCount = n;
        int currentNumber = 1;
        int lastNumber = (n * (n + 1)) / 2;


        for (int cycle = 0; cycle < cycleCount; cycle++) {
            for (int i = 0; i < writeCount; i++) {
                if (currentNumber > lastNumber) break;
                answer[currentX++][currentY] = currentNumber++;
                if (i == writeCount - 1) {
                    currentX--;
                    writeCount--;
                }
            }
            currentY++;

            for (int i = 0; i < writeCount; i++) {
                if (currentNumber > lastNumber) break;
                answer[currentX][currentY++] = currentNumber++;
                if (i == writeCount - 1) {
                    currentY--;
                    writeCount--;
                }
            }

            currentX--;
            currentY--;

            for (int i = 0; i < writeCount; i++) {
                if (currentNumber > lastNumber) break;
                answer[currentX--][currentY--] = currentNumber++;
                if (i == writeCount - 1) {
                    currentX++;
                    currentY++;
                    writeCount--;
                }
            }

            currentX++;
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for (int j = 0; j < i+1; j++){
                result.add(answer[i][j]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
