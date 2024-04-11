import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class problem2 {
    public static void main(String[] args) {
        int value = solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println(value);
    }
    public static int solution(int[][] maps) {
        int[][] valueMap = new int[maps.length][maps[0].length];
        for(int[] list : valueMap){
            Arrays.fill(list,Integer.MAX_VALUE);
        }
        Queue<int[]> positionQueue = new LinkedList<>();

        valueMap[maps.length-1][maps[0].length-1] = 1;
        positionQueue.add(new int[]{maps.length-1,maps[0].length-1,1});
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        while (!positionQueue.isEmpty()){
            int[] currentPosition = positionQueue.poll();
            int count = currentPosition[2];

            for(int i = 0; i < 4; i ++){
                int nextX = currentPosition[0]+dx[i];
                int nextY = currentPosition[1]+dy[i];

                if(nextX == 0 && nextY == 0) return count+1;
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length ) continue;
                if (maps[nextX][nextY] == 0 ) continue;
                if(valueMap[nextX][nextY] > count+1){
                    valueMap[nextX][nextY] = count+1;
                    positionQueue.add(new int[]{nextX,nextY,count+1});
                }
            }
        }
        if(valueMap[0][0] == Integer.MAX_VALUE) return -1;
        return valueMap[0][0];
    }
}
