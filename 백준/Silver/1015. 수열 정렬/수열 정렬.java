import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Number> numbers = new ArrayList<>();
    static int n;
    static int[] result;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        result = new int[n];
        var input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers.add(new Number(Integer.parseInt(input[i]), i));
        }
    }

    static void solution() {
        Collections.sort(numbers);
        for (int i = 0; i < n; i++) {
            var number = numbers.get(i);
            result[number.index] = i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class Number implements Comparable<Number> {
        int number, index;

        public Number(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public int compareTo(Number other) {
            if (this.number == other.number) {
                return this.index - other.index;
            }
            return this.number - other.number;
        }
    }
}
