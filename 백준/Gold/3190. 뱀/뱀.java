import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static Queue<Time> times = new LinkedList<>();

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        board = new int[N][N];

        int appleCnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < appleCnt; i++) {
            String[] appleInput = sc.nextLine().split(" ");
            board[Integer.parseInt(appleInput[0]) - 1][Integer.parseInt(appleInput[1]) - 1] = 1;
        }

        int timeCnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < timeCnt; i++) {
            String[] timeInput = sc.nextLine().split(" ");
            times.add(new Time(Integer.parseInt(timeInput[0]), timeInput[1]));
        }
    }

    public static void solve() {
        int currTime = 0;
        Snake snake = new Snake();
        snake.initialize();

        while (true) {
            try {
                currTime++;
                snake.move();
                if (!times.isEmpty() && times.peek().time == currTime) {
                    Time time = times.poll();
                    snake.turn(time.D);
                }
            } catch (RuntimeException exception) {
                break;
            }
        }

        System.out.println(currTime);
    }

    enum Dest {
        LEFT(0, -1), RIGHT(0, 1), TOP(-1, 0), BOTTOM(1, 0);

        static final Map<Dest, Dest> turnLeftMap = new EnumMap<>(Dest.class);
        static final Map<Dest, Dest> turnRightMap = new EnumMap<>(Dest.class);

        static {
            turnLeftMap.put(LEFT, BOTTOM);
            turnLeftMap.put(BOTTOM, RIGHT);
            turnLeftMap.put(RIGHT, TOP);
            turnLeftMap.put(TOP, LEFT);

            turnRightMap.put(LEFT, TOP);
            turnRightMap.put(TOP, RIGHT);
            turnRightMap.put(RIGHT, BOTTOM);
            turnRightMap.put(BOTTOM, LEFT);
        }

        final int dy;
        final int dx;

        Dest(int dy, int dx) {
            this.dy = dy;
            this.dx = dx;
        }

        public Dest turnLeft() {
            return turnLeftMap.get(this);
        }

        public Dest turnRight() {
            return turnRightMap.get(this);
        }
    }

    static class Snake {
        List<Node> list = new ArrayList<>();
        Dest dest = Dest.RIGHT;

        public void initialize() {
            list.add(new Node(0, 0));
        }

        public void move() {
            List<Node> temp = new ArrayList<>();
            Node nextHead = list.get(0).getNext(dest);
            checkCrash(nextHead);

            temp.add(nextHead);
            for (int i = 0; i < list.size() - 1; i++) {
                temp.add(list.get(i));
            }
            if (board[nextHead.y][nextHead.x] != 0) {
                board[nextHead.y][nextHead.x] = 0;
                temp.add(list.get(list.size() - 1));
            }
            list = temp;
        }

        public void turn(String D) {
            if (D.equals("D")) {
                this.dest = dest.turnRight();
                return;
            }
            this.dest = dest.turnLeft();
        }

        private void checkCrash(Node nextHead) {
            for (Node node : list) {
                if (nextHead.y == node.y && nextHead.x == node.x) throw new RuntimeException();
            }
        }
    }

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        Node getNext(Dest dest) {
            int nextY = y + dest.dy;
            int nextX = x + dest.dx;
            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) throw new RuntimeException();
            return new Node(nextY, nextX);
        }
    }

    static class Time {
        int time;
        String D;

        Time(int time, String D) {
            this.time = time;
            this.D = D;
        }
    }
}
