import java.util.Scanner;

public class Main {
    static int N;
    static int[] buildings;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        buildings = new int[N];
        String[] buildingInput = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(buildingInput[i]);
        }
    }

    public static void solve() {
        // for 50
        // for left, for right
        // 각 사이마다
        int result = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (check(i, j)) cnt++;
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    public static boolean check(int start, int end) {
        int indexAdder;
        if (end > start) {
            indexAdder = 1;
        } else {
            indexAdder = -1;
        }
        double adder = getCalculate(start, end);

        for (int i = start + indexAdder; i != end; i += indexAdder) {
            int distance = Math.abs(start - i);
            double value = buildings[start] + adder * distance;
            if (value > buildings[i]) continue;
            return false;
        }
        return true;
    }

    public static double getCalculate(int start, int end) {
        double distance = Math.abs(end - start);
        return (buildings[end] - buildings[start]) / distance;
    }
}
