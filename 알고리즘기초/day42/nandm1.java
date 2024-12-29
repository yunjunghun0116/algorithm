import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class nandm1 {
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> numbers = new ArrayList<>();
    static int n;
    static int m;

    static void input() {
        var sc = new Scanner(System.in);
        var inputs = sc.nextLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        var numberInputs = sc.nextLine().split(" ");
        for (var number : numberInputs) {
            numbers.add(Integer.parseInt(number));
        }

        numbers.sort((a, b) -> a - b);
    }

    static void solution(int lastIndex) {
        if (arr.size() == m) {
            print();
            return;
        }
        for (int i = lastIndex; i < n; i++) {
            arr.add(numbers.get(i));
            solution(i + 1);
            arr.remove(arr.size() - 1);
        }
    }

    static void print() {
        for (int i = 0; i < m; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        input();
        solution(0);
    }
}
