import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<int[]> cases = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        for (int[] c : cases) {
            int result = doCase(c[0], c[1]);
            System.out.println(result);
        }
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] caseInput = sc.nextLine().split(" ");
            cases.add(new int[]{Integer.parseInt(caseInput[0]), Integer.parseInt(caseInput[1])});
        }
    }

    public static int doCase(int s, int e) {
         /*
             0, 5 => 0, 1, 3, 4, 5 => 4 가운데를 지날 경우 올라갔다 내려가기
             1, 5 => 1, 2, 4, 5 => 3 가운데가 없을 경우 그만큼 한번 더 => -1
             0, 3 => 0, 1, 2, 3 => 3 1+2+3+4+ .. => (1+n)/2
             거리가 1일때 = 1
             2일때 => 1,1 => 2
             3일때 => 1,1,1 => 3
             4일때 => 1,2,1 => 3
             5일때 => 1,2,1,1 => 4
             6일때 => 1,2,2,1 => 4
             7일때 => 1,2,2,1,1 => 5
             8일때 => 1,2,2,2,1 => 5
             9일때 => 1,2,3,2,1 => 5
             10일때 => 1,2,3,2,1,1 => 6
             11일때 => 1,2,3,2,2,1 => 6
             12일때 => 1,2,3,3,2,1 => 6
             13일때 => 1,2,3,3,2,1,1 => 7
             14일때 => 1,2,3,3,2,2,1 => 7
             15일때 => 1,2,3,3,3,2,1 => 7
             16일때 => 1,2,3,4,3,2,1 => 7
             1(1), 4(3), 9(5), 16(7), 25(9), ...
             1, (1,2), (2,3), (3,4), (4,5)
             1. 둘의 거리의 차이를 구하고
             2. 해당하는 영역을 보고(거리보다 작은 수 중 최대(n^2))
         */
        int dist = e - s;
        if (dist == 1) return 1;
        int num = (int) Math.sqrt(dist);

        if (num * num == dist) {
            return 2 * num - 1;
        }
        if (dist <= num * (num + 1)) {
            return 2 * num;
        }
        return 2 * num + 1;
        // if 거리가 10일때, num = 3,
        // 시작점 : (num)*(num)+1부터 +num 까지는 2*(num)
        // 그다음은 2*num+1
        // if 제곱으로 나누어떨어진다면 2*num-1
    }
}
