import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 옆으로 계속 일정 or 늘어남 -> 같은 건물이 있을테니까,,,
    // 크면 stack에 추가 -> Stack을 이용하고, 앞에서부터 그냥 계속 집어넣으면 될 것 같은데
    // 커? 그러면 stack에 추가
    // 1 2 1(+1) 3 1(+1) 0(+1) 2 3 2(+1) 1(+1) +1 총 6개?
    static int N;
    static Stack<Integer> heightStack = new Stack<>();

    public static void main(String[] args) {
        System.out.println(initialize());
    }

    public static int initialize() {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            String[] heightInput = sc.nextLine().split(" ");
            int nextHeight = Integer.parseInt(heightInput[1]);
            if (heightStack.isEmpty()) {
                heightStack.push(nextHeight);
                continue;
            }
            if (heightStack.peek() < nextHeight) {
                heightStack.push(nextHeight);
                continue;
            }
            while (!heightStack.isEmpty() && heightStack.peek() > nextHeight) {
                heightStack.pop();
                result++;
            }
            if (heightStack.isEmpty() || heightStack.peek() < nextHeight) {
                heightStack.push(nextHeight);
            }
        }

        while (!heightStack.isEmpty() && heightStack.peek() > 0) {
            heightStack.pop();
            result++;
        }

        return result;
    }
}
