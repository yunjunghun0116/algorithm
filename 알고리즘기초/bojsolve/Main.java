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
     * 다이나믹 프로그래밍 : 11726, 1003, 10870, 15988, 15991, 11052, 2011, 2579, 1149, 2156, 2193, 9465, 1309, 2688, 11057
     * 다이나믹 프로그래밍 - 역추적 : 2688, 1562, 2096, 5557, 1495, 9095, 15988, 15990
     * 다이나믹 프로그래밍 - 그외 : 11066, 11049, 10942, 1509, 15681, 1949
     */

    static int[] dp = new int[12];
    static int n;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            var number = Integer.parseInt(sc.nextLine());
            System.out.println(dp[number]);
        }
    }

    static void solution() {
        for(int i = 1; i <= 11; i++){
            if(i <= 3){
                var cnt = 1;
                for(int j = 1; j < i; j++){
                    cnt+= dp[j];
                }
                dp[i] = cnt;
                continue;
            }
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
    }

    public static void main(String[] args) {
        solution();
        input();
    }
}
