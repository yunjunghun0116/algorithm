public class bible2 {
    public int solution(int[][] dots) {
        int[][] points = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
        for (int[] point : points) {
            if (getInclination(dots[point[0]], dots[point[1]]) == getInclination(dots[point[2]], dots[point[3]])) {
                return 1;
            }
        }
        return 0;
    }

    public double getInclination(int[] a, int[] b) {
        return (double) (b[1] - a[1]) / (b[0] - a[0]);
    }
}
