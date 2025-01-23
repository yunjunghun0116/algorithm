import java.util.Scanner;

public class Main {
    public static long[][] pointArray;

    public static void main(String[] args) {
        initialize();
        String result = String.format("%.1f", (Math.abs(solve()) / 2.0));
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        pointArray = new long[n + 1][2];

        for (int i = 0; i < n; i++) {
            String[] pointInput = sc.nextLine().split(" ");
            pointArray[i] = new long[]{Long.parseLong(pointInput[0]), Long.parseLong(pointInput[1])};
        }

        pointArray[n] = pointArray[0];
    }

    public static long solve() {
        long r1 = 0;
        long r2 = 0;

        for (int i = 0; i < pointArray.length - 1; i++) {
            r1 += pointArray[i][0] * pointArray[i + 1][1];
            r2 += pointArray[i][1] * pointArray[i + 1][0];
        }

        return r1 - r2;
    }
}
