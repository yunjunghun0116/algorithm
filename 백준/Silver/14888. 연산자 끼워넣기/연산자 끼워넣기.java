import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int n;
    public static List<Integer> numberList = new ArrayList<>();
    public static int[] opArray = new int[4];
    public static int maxValue = Integer.MIN_VALUE;
    public static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        initialize();
        solve(1, numberList.get(0));
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        for (String number : sc.nextLine().split(" ")) {
            numberList.add(Integer.parseInt(number));
        }

        String[] opInput = sc.nextLine().split(" ");
        for (int i = 0; i < 4; i++) {
            opArray[i] = Integer.parseInt(opInput[i]);
        }
    }

    public static void solve(int currIndex, int currNumber) {
        if (currIndex == n) {
            maxValue = Math.max(maxValue, currNumber);
            minValue = Math.min(minValue, currNumber);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opArray[i] == 0) continue;
            opArray[i] = opArray[i] - 1;
            solve(currIndex + 1, operation(i, currNumber, numberList.get(currIndex)));
            opArray[i] = opArray[i] + 1;
        }
    }

    public static int operation(int opIndex, int originNumber, int nextNumber) {
        switch (opIndex) {
            case 0: {
                return originNumber + nextNumber;
            }
            case 1: {
                return originNumber - nextNumber;
            }
            case 2: {
                return originNumber * nextNumber;
            }
            default: {
                if (originNumber < 0 && nextNumber > 0) {
                    return -1 * ((-1 * originNumber) / nextNumber);
                }
                return originNumber / nextNumber;
            }
        }
    }
}
