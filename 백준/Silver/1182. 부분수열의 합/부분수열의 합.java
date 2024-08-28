import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    static int[] numbers;
    static int n;
    static int s;
    static int cnt = 0;

    static void input() {
        var sc = new Scanner(System.in);
        var sizeInput = sc.nextLine().split(" ");
        n = Integer.parseInt(sizeInput[0]);
        s = Integer.parseInt(sizeInput[1]);
        numbers = new int[n];

        var numberInput = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }
    }

    static void solution(int currIndex) {
        if (currIndex == n) {
            check();
            return;
        }
        arr.add(numbers[currIndex]);
        solution(currIndex + 1);
        arr.remove(arr.size() - 1);

        solution(currIndex + 1);
    }

    static void check() {
        if (arr.isEmpty()) return;
        var sum = 0;
        for (var number : arr) {
            sum += number;
        }
        if (sum == s) {
            cnt++;
        }
    }

    public static void main(String[] args) {
        input();
        solution(0);

        System.out.println(cnt);
    }
}
