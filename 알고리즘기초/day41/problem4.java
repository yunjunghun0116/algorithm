import java.util.*;

public class problem4 {


    public static void main(String[] args) {
        int[] result = solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] maps) {
        int height = maps.length;
        int width = maps[0].length();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[][] mapsValue = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                String value = String.valueOf(maps[h].charAt(w));
                if (value.equals("X")) continue;
                mapsValue[h][w] = Integer.parseInt(value);
            }
        }

        boolean[][] visited = new boolean[height][width];
        List<Integer> result = new ArrayList<>();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (mapsValue[h][w] == 0 || visited[h][w]) continue;
                int value = 0;
                Stack<int[]> positionStack = new Stack<>();
                visited[h][w] = true;
                positionStack.push(new int[]{h, w});

                while (!positionStack.isEmpty()) {
                    int[] popData = positionStack.pop();
                    value += mapsValue[popData[0]][popData[1]];

                    for (int i = 0; i < 4; i++) {
                        int nextH = popData[0] + dy[i];
                        int nextW = popData[1] + dx[i];
                        if (nextH >= height || nextH < 0 || nextW >= width || nextW < 0 || visited[nextH][nextW] || mapsValue[nextH][nextW] == 0)
                            continue;
                        visited[nextH][nextW] = true;
                        positionStack.push(new int[]{nextH, nextW});
                    }
                }
                result.add(value);
            }
        }

        if (result.isEmpty()) return new int[]{-1};
        result.sort((a, b) -> a - b);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
