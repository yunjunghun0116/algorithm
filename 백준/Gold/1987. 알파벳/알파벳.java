import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static Set<Character> charSet = new HashSet<>();
    public static int R, C;
    public static boolean[][] visited;
    public static char[][] map;
    public static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        initialize();
        solve();
        System.out.println(maxValue);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        R = Integer.parseInt(sizeInput[0]);
        C = Integer.parseInt(sizeInput[1]);

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    public static void solve() {
        charSet.add(map[0][0]);
        dfs(0, 0);
    }

    public static void dfs(int y, int x) {
        maxValue = Math.max(charSet.size(), maxValue);

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) continue;
            if (charSet.contains(map[nextY][nextX])) continue;
            charSet.add(map[nextY][nextX]);
            dfs(nextY, nextX);
            charSet.remove(map[nextY][nextX]);
        }
    }
}
