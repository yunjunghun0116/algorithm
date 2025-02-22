import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] items;
    public static int[] MIN_TWIN;

    public static void main(String[] args) {
        initialize();
        find();
        System.out.println(MIN_TWIN[0] + " " + MIN_TWIN[1]);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        items = new int[N];

        String[] itemInput = sc.nextLine().split(" ");

        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(itemInput[i]);
        }

        Arrays.sort(items);
    }

    public static void find() {
        int right = items.length - 1;
        for (int left = 0; left < right; left++) {
            while (left < right - 1 && Math.abs(items[left] + items[right - 1]) < Math.abs(items[left] + items[right])) {
                right--;
            }
            while (right < N && needAdd(left, right)) {
                if (needAdd(left, right)) {
                    right++;
                }
            }

            int leftItem = items[left];
            int rightItem = items[right];

            if (left == 0 || Math.abs(leftItem + rightItem) < Math.abs(MIN_TWIN[0] + MIN_TWIN[1])) {
                MIN_TWIN = new int[]{leftItem, rightItem};
            }
        }
    }

    public static boolean needAdd(int leftIndex, int rightIndex) {
        if (rightIndex == N - 1) return false;
        int left = items[leftIndex];
        int right = items[rightIndex];
        int rightNext = items[rightIndex + 1];
        return Math.abs(left + rightNext) < Math.abs(left + right);
    }
}
