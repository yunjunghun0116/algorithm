import java.util.*;

public class Main {
    public static int N;
    public static List<Long> result = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        solve();
        print();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
    }

    public static void solve() {
        Queue<String> queue = new LinkedList<>();
        int currNum = -1;
        queue.add("");
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str.length() == 0) {
                for (int i = 0; i <= 9; i++) {
                    String newStr = str + String.valueOf(i);
                    queue.add(newStr);
                }
                continue;
            }
            addReverseString(str);
            int lastNum = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1)));
            for (int i = lastNum + 1; i <= 9; i++) {
                String newStr = str + String.valueOf(i);
                queue.add(newStr);
            }
        }
    }

    public static void addReverseString(String str) {
        String s = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            s = s + str.charAt(i);
        }
        result.add(Long.parseLong(s));
    }

    public static void print() {
        Collections.sort(result);
        if (N >= result.size()) {
            System.out.println(-1);
            return;
        }
        System.out.println(result.get(N));
    }
}
