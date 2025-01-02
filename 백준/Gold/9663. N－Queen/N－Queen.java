import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    static boolean[] used;
    static int n;
    static int cnt = 0;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        used = new boolean[n];
    }

    static void solution() {
        if (arr.size() == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (canUse(i)) {
                used[i] = true;
                arr.add(i);
                solution();
                arr.remove(arr.size() - 1);
                used[i] = false;
            }
        }
    }

    static boolean canUse(int jIndex) {
        for (int i = 0; i < arr.size(); i++) {
            if (Math.abs(arr.size() - i) == Math.abs(arr.get(i) - jIndex)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        solution();

        System.out.println(cnt);
    }
}
