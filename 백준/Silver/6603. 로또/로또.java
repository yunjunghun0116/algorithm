import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("0")) break;
            solve(input);
        }
    }

    public static void solve(String str) {
        String[] input = str.split(" ");
        int n = Integer.parseInt(input[0]);

        int[] numbers = new int[n];
        for (int i = 1; i < input.length; i++) {
            numbers[i - 1] = Integer.parseInt(input[i]);
        }

        combination(numbers, 0, 6);
        System.out.println();
    }

    public static void combination(int[] numbers, int index, int length) {
        if (temp.size() == length) {
            for (int i = 0; i < length; i++) {
                System.out.print(temp.get(i) + " ");
            }
            System.out.println();
            return;
        }
        if (index >= numbers.length) return;

        temp.add(numbers[index]);
        combination(numbers, index + 1, length);
        temp.remove(temp.size() - 1);
        combination(numbers, index + 1, length);
    }
}
