import java.util.Scanner;

public class Main {
    // 대충 32000까지... 재귀로 했을때 괜찮으려나
    // 64 -> 0, 16, 32, 48 이 시작
    // 16 -> 0, 4, 8, 12 가 시작 => 일단 4로 나눌 수 있다,,?
    // 64 -> 0,0 ~ 3,3, 0,4 ~ 7,3, 4,0 ~
    public static int N, r, c;

    public static void main(String[] args) {
        initialize();
        setBoard(0, 0, 0, (int) Math.pow(2, N));
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
    }

    public static void setBoard(int startY, int startX, int number, int length) {
        if (length == 1) {
            if (startY == r && startX == c) {
                System.out.println(number);
            }
            return;
        }
        int nextLength = length / 2;
        int temp = nextLength * nextLength;
        if (r < startY + nextLength && c < startX + nextLength) {
            setBoard(startY, startX, number, nextLength);
            return;
        }
        if (r < startY + nextLength && c >= startX + nextLength) {
            setBoard(startY, startX + nextLength, number + temp, nextLength);
            return;
        }
        if (r >= startY + nextLength && c < startX + nextLength) {
            setBoard(startY + nextLength, startX, number + temp * 2, nextLength);
            return;
        }
        if (r >= startY + nextLength && c >= startX + nextLength) {
            setBoard(startY + nextLength, startX + nextLength, number + temp * 3, nextLength);
        }
    }
}
