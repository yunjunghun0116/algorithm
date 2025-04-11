import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String[] sizeInput = sc.nextLine().split(" ");
            N = Integer.parseInt(sizeInput[0]);
            M = Integer.parseInt(sizeInput[1]);
            if (N == 0 && M == 0) break;
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] lineInput = sc.nextLine().split(" ");
                for (String str : lineInput) {
                    int value = map.getOrDefault(Integer.parseInt(str), 0);
                    value++;
                    map.put(Integer.parseInt(str), value);
                }
            }

            solve();
        }
    }

    public static void solve() {
        List<Item> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(new Item(entry.getKey(), entry.getValue()));
        }
        result.sort((a, b) -> b.cnt - a.cnt);
        int firstValue = result.get(0).cnt;

        List<Integer> answer = new ArrayList<>();
        int secondValue = 0;
        for (Item item : result) {
            if (item.cnt == firstValue) continue;
            if (secondValue == 0) {
                secondValue = item.cnt;
                answer.add(item.number);
                continue;
            }
            if (secondValue == item.cnt) {
                answer.add(item.number);
                continue;
            }
            break;
        }

        answer.sort((a, b) -> a - b);
        for (int num : answer) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static class Item {
        int number;
        int cnt;

        public Item(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }
}
