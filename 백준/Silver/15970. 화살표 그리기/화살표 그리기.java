import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // 20291 15970
    static Map<Integer, List<Integer>> dotsMap = new HashMap<>();
    static int n;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            var input = sc.nextLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int color = Integer.parseInt(input[1]);
            var currDots = dotsMap.getOrDefault(color, new ArrayList<>());
            currDots.add(num);
            dotsMap.put(color, currDots);
        }
    }

    static void solution() {
        int sum = 0;
        for (var entry : dotsMap.entrySet()) {
            sum += getValue(entry.getValue());
        }
        System.out.println(sum);
    }

    static int getValue(List<Integer> dots) {
        Collections.sort(dots);
        int sum = 0;
        for (int i = 0; i < dots.size(); i++) {
            if (i == 0) {
                sum += dots.get(i + 1) - dots.get(i);
                continue;
            }
            if (i == dots.size() - 1) {
                sum += dots.get(i) - dots.get(i - 1);
                continue;
            }
            sum += Math.min(Math.abs(dots.get(i) - dots.get(i - 1)), Math.abs(dots.get(i) - dots.get(i + 1)));
        }
        return sum;
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
