import java.util.*;

public class Main {
    public static int N, K;
    public static int[] belt;
    public static int time = 0;
    public static Queue<Robot> robotQueue = new LinkedList<>();

    public static void main(String[] args) {
        initialize();
        solve();
    }

    // 021212 => 202121 => 201121(1)
    // 101121 => 110112 => 110112
    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        K = Integer.parseInt(sizeInput[1]);

        String[] numInput = sc.nextLine().split(" ");
        belt = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(numInput[i]);
        }
    }

    public static void solve() {
        while (!isFinish()) {
            time++;
            moveBelt();
        }

        System.out.println(time);
    }
    // 로봇을 올리거나 이동할 때마다 내구도가 1씩 감소한다. => 이동 가능할 때랑 이동 불가능할 때
    // 이동 가능할 때 : 다음 칸의 내구도가 1 이상이어야 함 => 1을 감소해준다.
    // 이동 불가능할 때 : 다음 칸의 내구도가 0 이거나 해당 칸에 이미 로봇이 있다.
    // 2N부터 1까지 역순으로 이동 가능에 대해 체크를 해야한다.
    // 컨베이어 벨트는 그대로 고정하되, 로봇의 위치를 계속 이동해야 한다.
    // 로봇은 그러면 위치를 저장하면 되는것 아닐까?
    // 그리고 로봇은 Queue 에다 지정하고, 만약 위치가 N이 되면 그때 내려주면 되겠구나

    public static void moveBelt() {
        // belt 이동
        int lastBelt = belt[2 * N - 1];
        for (int i = 2 * N - 2; i >= 0; i--) {
            belt[i + 1] = belt[i];
        }
        belt[0] = lastBelt;
        // 로봇도 한칸씩 기본적으로는 이동
        Queue<Robot> tempQueue = new LinkedList<>();
        Set<Integer> currPosSet = new HashSet<>();

        while (!robotQueue.isEmpty()) {
            Robot robot = robotQueue.poll();
            robot.defaultMove();
            if (robot.currentPosition == N - 1) continue;
            if (!currPosSet.contains(robot.currentPosition + 1) && belt[robot.currentPosition + 1] > 0) {
                robot.move();
            }
            if (robot.currentPosition == N - 1) continue;
            currPosSet.add(robot.currentPosition);
            tempQueue.add(robot);
        }

        if (belt[0] > 0 && !currPosSet.contains(0)) {
            tempQueue.add(new Robot(0));
        }

        robotQueue = tempQueue;
    }

    public static boolean isFinish() {
        int cnt = 0;
        for (int durability : belt) {
            if (durability == 0) cnt++;
        }
        if (cnt >= K) return true;
        return false;
    }

    static class Robot {
        int currentPosition;

        public Robot(int currentPosition) {
            this.currentPosition = currentPosition;
            belt[0] = belt[0] - 1;
        }

        public void defaultMove() {
            this.currentPosition = this.currentPosition + 1;
        }

        public void move() {
            if (belt[currentPosition + 1] > 0) {
                belt[currentPosition + 1] = belt[currentPosition + 1] - 1;
                currentPosition++;
            }
        }
    }
}
