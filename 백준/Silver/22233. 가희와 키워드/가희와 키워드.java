import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int N, M;
    static Set<String> stringSet = new HashSet<>();

    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);

        for (int i = 0; i < N; i++) {
            stringSet.add(sc.nextLine());
        }

        for (int i = 0; i < M; i++) {
            String[] strings = sc.nextLine().split(",");
            for (String str : strings) {
                stringSet.remove(str);
            }
            System.out.println(stringSet.size());
        }
    }

    public static void solve() {

    }
}
