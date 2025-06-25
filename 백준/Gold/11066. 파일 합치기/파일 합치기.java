import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);

        int testcase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcase; i++) {
            int size = Integer.parseInt(sc.nextLine());
            int[] files = new int[size];
            String[] fileInput = sc.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                files[j] = Integer.parseInt(fileInput[j]);
            }

            int result = solve(files);
            System.out.println(result);
        }
    }

    public static int solve(int[] files) {
        // 계속적으로 합치는 과정을 진행해 최종적으로 하나로 만들어야 한다.
        /*
FILES
| 0   | 1   | 2   | 3   |
| 40  | 30  | 30  | 50  |

DP
| i\j | 0   | 1   | 2   | 3   | 4   |
| --- | --- | --- | --- | --- | --- |
| 0   | 0   | 0   | 0   | 0   | 0   |
| 1   |     | 0   | 70  | 160 | 300 |
| 2   |     |     | 0   | 60  | 170 |
| 3   |     |     |     | 0   | 80  |
| 4   |     |     |     |     | 0   |

1. (0,0), (1,1), (2,2), (3,3), (4,4) 를 0으로 세팅
2. 예를 들어 dp(1,3) 는 (40, 30, 30) 을 합치는 최소 비용을 나타내는 것이고, 이게 (40, 30+30)[비용 : 60]후 (40+60)[비용 : 100] 인 경우의 비용 총 합
3. 결국 채워나가는 것은 1부터 시작해서 길이가 1일때, 2일때, ..., n 일때까지 계속 더해나가며 길이만큼 채워나가는 것
4. 그런데 이게 채울때도 (1~4)를 (1)과 (2,3,4)를 합치는 방법, (1,2)와 (3,4)를 합치는 방법, (1,2,3)과 (4)를 합치는 방법이 존재할 수 있음
5. 그리고 어찌어찌하다보면 최종적으로는 dp(a,b)는 (a~b)까지의 총합은 맨 마지막에 더해줄 수 밖에 없음
   그 이유는 dp(a,b)는 dp(a,k)+dp(k+1,b) 의 최솟값을 합치는 것인데, 이게 합쳐진 최종 덩어리는 a~b의 모든 원소의 합이기 때문임
   그렇기 때문에 dp(a,b) = dp(a,k) + dp(k+1,b) + a~b의 원소 합(이 부분은 sum 배열로 미리 계산을 해두었음)
   약간, dp(a,k) - 왼쪽 덩어리, dp(k+1, b) - 오른쪽 덩어리 를 좀 더 쉽게 풀이하자면
   각각의 덩어리인 dp(i, j) 는 i~j를 합치는 데 드는 최소 비용이고
   각각의 덩어리끼리 최소비용으로 만들었으니, 합쳐보면 왼쪽 최소비용 + 오른쪽 최소비용 + 이번에 합치는 비용 으로 생각할 수 있다.

SUM
| 0   | 1   | 2   | 3   | 4   |
| 0   | 40  | 70  | 100 | 150 |
        * */
        int size = files.length;
        int[] sum = new int[size + 1];
        int[][] dp = new int[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {
            sum[i] = sum[i - 1] + files[i - 1];
        }
        for (int len = 1; len < size + 1; len++) {
            for (int start = 1; start + len < size + 1; start++) {
                int end = start + len;
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k < end; k++) {
                    dp[start][end] = Math.min(
                            dp[start][end],
                            dp[start][k] + dp[k + 1][end] + sum[end] - sum[start - 1]
                    );
                }
            }
        }

        return dp[1][size];
    }
}
