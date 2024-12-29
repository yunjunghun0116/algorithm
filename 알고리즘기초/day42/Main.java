import java.util.Scanner;

public class Main {
    /**
     * 정렬 : 20291
     * 이분탐색 : 7795, 1920, 1764, 3273, 10816, 2470
     * 매개변수탐색(이분탐색 응용) : 2805, 2110, 1654, 2512, 2343, 6236, 13702, 17266, 1300(고), 1637(고)
     * 투포인터 : 1806, 2003, 2559, 15565, 11728, 2230, 13144, 1253, 2473, 16472
     * 그래프 탐색 : 1260, 2667, 1012, 11724, 4963, 3184, 2606, 11403, 11725, 2251, 14502, 2178, 1697, 1387, 5567, 3055, 7569, 2644
     * 트리: 11725, 1991, 5639, 15900, 20364, 3584, 1240, 9489, 1068, 15681, 14267,
     * 위상정렬 : 1005, 2252, 1516, 2056, 2637
     * 최단거리(다익스트라) : 1916
     * 다이나믹 프로그래밍 : 9095, 11726, 1003, 10870, 15988, 15991, 11052, 2011, 2579, 1149, 2156, 2193, 9465, 1309, 2688, 11057
     * 다이나믹 프로그래밍 - 역추적 : 2688, 1562, 2096, 5557, 1495, 9095, 15988, 15990
     * 다이나믹 프로그래밍 - 그외 : 11066, 11049, 10942, 1509, 15681, 1949
     */

    static int[] stairs;
    static int n;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(sc.nextLine());
        }
    }

    static void solution() {
        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }
        var dp = new int[n + 1];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }
        String s = Integer.toBinaryString(n);

        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
