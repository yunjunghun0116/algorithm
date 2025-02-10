import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N, W, L;
    public static Queue<Integer> trucks = new LinkedList<>();
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        initialize();
        solution();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);

        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        W = Integer.parseInt(sizeInput[1]);
        L = Integer.parseInt(sizeInput[2]);

        for (String truck : sc.nextLine().split(" ")) {
            trucks.add(Integer.parseInt(truck));
        }

        for (int i = 0; i < W; i++) {
            queue.add(0);
        }
    }

    public static void solution() {
        int currentWeight = 0;
        int currentTime = 0;

        while (!trucks.isEmpty()) {
            currentWeight -= queue.poll();
            currentTime++;

            if (currentWeight + trucks.peek() <= L) {
                int truck = trucks.poll();
                queue.add(truck);
                currentWeight += truck;
            } else {
                queue.add(0);
            }
        }

        while (!queue.isEmpty()) {
            queue.poll();
            currentTime++;
        }

        System.out.println(currentTime);
    }
}
