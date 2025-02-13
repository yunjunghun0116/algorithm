import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int N, K;
    private static List<Item> itemList = new ArrayList<>();
    private static int[][] dp;

    public static void main(String[] args) {
        initialize();
        setDP();
        System.out.println(dp[N][K]);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        N = Integer.parseInt(sizeInput[0]);
        K = Integer.parseInt(sizeInput[1]);
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            String[] itemInput = sc.nextLine().split(" ");
            Item item = new Item(Integer.parseInt(itemInput[0]), Integer.parseInt(itemInput[1]));
            itemList.add(item);
        }
    }

    public static void setDP() {
        for (int i = 1; i <= N; i++) {
            Item item = itemList.get(i - 1);
            for (int j = 1; j <= K; j++) {
                if (j < item.weight) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j - item.weight] + item.value, dp[i - 1][j]);
            }
        }
    }

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
