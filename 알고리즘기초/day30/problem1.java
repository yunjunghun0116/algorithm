public class problem1 {
    //정확성 70점 효율성 0점 총 70점 / 100점 -> 효율성(시간 및 메모리) 개선

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int value = solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println(value);
    }

    public static int solution(int[][] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        dfs(maps, visited, maps.length - 1, maps[0].length - 1, 1);

        return answer;
    }

    public static void dfs(int[][] maps, boolean[][] visited, int y, int x, int count) {
        if (x == 0 && y == 0) {
            if (count < answer) {
                answer = count;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextY < 0 || nextY >= visited.length || nextX < 0 || nextX >= visited[0].length) continue;
            if (maps[nextY][nextX] == 0 || visited[nextY][nextX]) continue;


            visited[nextY][nextX] = true;
            dfs(maps, visited, nextY, nextX, count + 1);
            visited[nextY][nextX] = false;
        }
    }


}
