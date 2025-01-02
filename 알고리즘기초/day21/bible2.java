public class bible2 {
    public static void main(String[] args) {
        System.out.println("solution() = " + solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}));
    }

    public static int solution(int[][] board) {
        int[][] result = board;
        int[][] points = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1},};
        int answer = 0;
        int size = board[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (result[i][j] == 1) {
                    for (int[] point : points) {
                        int x = i + point[0];
                        int y = j + point[1];
                        if (x < 0 || x >= size || y < 0 || y >= size) {
                            continue;
                        }
                        if(result[x][y]==1) continue;
                        result[x][y] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (result[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
