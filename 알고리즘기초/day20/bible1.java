import java.util.Arrays;
import java.util.Comparator;

public class bible1 {
    public int solution(int[][] dots) {
        int[][] sortedDots = dots;
        Arrays.sort(sortedDots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        //같은 기능을 수행함
        //Arrays.sort(sortedDots, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int height = sortedDots[1][1] - sortedDots[0][1];
        int width = sortedDots[2][0] - sortedDots[0][0];

        return width * height;
    }
}
