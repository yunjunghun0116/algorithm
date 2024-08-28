import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 20291 15970
    static List<Integer> whitePoints = new ArrayList<>();
    static List<Integer> blackPoints = new ArrayList<>();
    static int n;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            var input = sc.nextLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int color = Integer.parseInt(input[1]);
            if (color == 1) {
                whitePoints.add(num);
                continue;
            }
            blackPoints.add(num);
        }
    }

    static void solution() {
        whitePoints.sort((a, b) -> a - b);
        blackPoints.sort((a, b) -> a - b);
        int sum = 0;

        for (int i = 0; i < whitePoints.size(); i++) {
            if (i == 0) {
                sum += whitePoints.get(1) - whitePoints.get(0);
                continue;
            }
            if (i == whitePoints.size() - 1) {
                sum += whitePoints.get(whitePoints.size() - 1) - whitePoints.get(whitePoints.size() - 2);
                continue;
            }
            sum += Math.min(Math.abs(whitePoints.get(i - 1) - whitePoints.get(i)), Math.abs(whitePoints.get(i + 1) - whitePoints.get(i)));
        }

        for (int i = 0; i < blackPoints.size(); i++) {
            if (i == 0) {
                sum += blackPoints.get(1) - blackPoints.get(0);
                continue;
            }
            if (i == blackPoints.size() - 1) {
                sum += blackPoints.get(blackPoints.size() - 1) - blackPoints.get(blackPoints.size() - 2);
                continue;
            }
            sum += Math.min(Math.abs(blackPoints.get(i - 1) - blackPoints.get(i)), Math.abs(blackPoints.get(i + 1) - blackPoints.get(i)));
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
