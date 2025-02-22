import java.util.Scanner;

public class Main {
    public static int N, M;
    public static long MAX;
    public static int[] trees;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);
        trees = new int[N];
        MAX = 0;

        String[] treeInput = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(treeInput[i]);
            MAX += trees[i];
        }
    }

    public static void solve() {
        long left = 0;
        long right = MAX;
        long mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long treeSum = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] >= mid) {
                    treeSum += trees[i] - mid;
                }
            }
            if (M == treeSum) {
                System.out.println(mid);
                return;
            }
            if (M > treeSum) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        System.out.println(left-1);
    }
}
