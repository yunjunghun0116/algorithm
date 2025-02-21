import java.util.*;

public class Main {
    public static Map<Integer, int[]> wheelMap = new HashMap<>();
    public static List<int[]> turnList = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        turnWheel();
        printResult();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 4; i++) {
            int[] wheel = new int[8];
            String wheelInput = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                wheel[j] = Integer.parseInt(String.valueOf(wheelInput.charAt(j)));
            }
            wheelMap.put(i, wheel);
        }

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] turnInput = sc.nextLine().split(" ");
            int[] turn = new int[]{Integer.parseInt(turnInput[0]), Integer.parseInt(turnInput[1])};
            turnList.add(turn);
        }
    }

    public static void turnWheel() {
        for (int[] turn : turnList) {
            int number = turn[0];
            int direction = turn[1];
            int[] turnArray = new int[5];
            turnArray[number] = direction;
            for (int i = number; i <= 4; i++) {
                if (!checkRightTurn(i)) break;
                turnArray[i + 1] = turnArray[i] * (-1);
            }
            for (int i = number; i >= 0; i--) {
                if (!checkLeftTurn(i)) break;
                turnArray[i - 1] = turnArray[i] * (-1);
            }

            for (int i = 1; i <= 4; i++) {
                if (turnArray[i] == 1) {
                    turnRight(i);
                }
                if (turnArray[i] == -1) {
                    turnLeft(i);
                }
            }
        }
    }

    public static void turnRight(int number) {
        int[] wheel = wheelMap.get(number);
        int lastNumber = wheel[7];

        for (int i = 6; i >= 0; i--) {
            wheel[i + 1] = wheel[i];
        }
        wheel[0] = lastNumber;
        wheelMap.put(number, wheel);
    }

    public static void turnLeft(int number) {
        int[] wheel = wheelMap.get(number);
        int firstNumber = wheel[0];

        for (int i = 1; i < 8; i++) {
            wheel[i - 1] = wheel[i];
        }
        wheel[7] = firstNumber;
        wheelMap.put(number, wheel);
    }

    public static boolean checkRightTurn(int number) {
        if (number == 4) return false;
        // 현재의 2와 다음의 6 인덱스 비교
        int[] currentWheel = wheelMap.get(number);
        int[] nextWheel = wheelMap.get(number + 1);
        return currentWheel[2] != nextWheel[6];
    }

    public static boolean checkLeftTurn(int number) {
        if (number == 1) return false;
        // 현재의 6와 다음의 2 인덱스 비교
        int[] currentWheel = wheelMap.get(number);
        int[] nextWheel = wheelMap.get(number - 1);
        return currentWheel[6] != nextWheel[2];
    }

    public static void printResult() {
        int result = 0;
        result += wheelMap.get(1)[0];
        result += wheelMap.get(2)[0] * 2;
        result += wheelMap.get(3)[0] * 4;
        result += wheelMap.get(4)[0] * 8;
        System.out.println(result);
    }
}
