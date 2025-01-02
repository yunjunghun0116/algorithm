import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Long> numbers = new ArrayList<>();
    static int n;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Long.parseLong(sc.nextLine()));
        }
    }

    static void solution() {
        var map = new HashMap<Long, Integer>();
        for (var number : numbers) {
            var val = map.getOrDefault(number, 0);
            map.put(number, val + 1);
        }

        var minNum = Long.MAX_VALUE;
        var maxCnt = -1;

        for (var entry : map.entrySet()) {
            if (entry.getValue() < maxCnt) continue;
            if (entry.getValue() == maxCnt) {
                minNum = Math.min(minNum, entry.getKey());
                continue;
            }
            maxCnt = entry.getValue();
            minNum = entry.getKey();
        }

        System.out.println(minNum);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
