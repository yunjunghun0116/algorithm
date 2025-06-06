import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] board;
    static int[][] water;
    static PriorityQueue<Tree> trees = new PriorityQueue<>((t1, t2) -> t1.age - t2.age);

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);

        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        int m = Integer.parseInt(sizeInput[1]);
        K = Integer.parseInt(sizeInput[2]);

        board = new int[N][N];
        water = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] waterInput = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = 5;
                water[i][j] = Integer.parseInt(waterInput[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] treeInput = sc.nextLine().split(" ");
            int x = Integer.parseInt(treeInput[1]) - 1;
            int y = Integer.parseInt(treeInput[0]) - 1;
            int age = Integer.parseInt(treeInput[2]);
            Tree tree = new Tree(y, x, age);

            trees.add(tree);
        }
    }

    public static void solve() {
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < K; i++) {
            // 봄
            Queue<Tree> tempTree = new LinkedList<>();
            Queue<Tree> diedTrees = new LinkedList<>();
            while (!trees.isEmpty()) {
                Tree tree = trees.poll();
                if (board[tree.y][tree.x] >= tree.age) {
                    board[tree.y][tree.x] -= tree.age;
                    tree.old();
                    tempTree.add(tree);
                } else {
                    diedTrees.add(tree);
                }
            }
            // 여름
            while (!diedTrees.isEmpty()) {
                Tree tree = diedTrees.poll();
                board[tree.y][tree.x] += tree.age / 2;
            }
            // 가을
            while (!tempTree.isEmpty()) {
                Tree aliveTree = tempTree.poll();
                // System.out.println("Tree 정보 { y : " + aliveTree.y + ", x : " + aliveTree.x + ", age : " + aliveTree.age);
                if (aliveTree.age % 5 == 0) {
                    for (int j = 0; j < 8; j++) {
                        int nextY = aliveTree.y + dy[j];
                        int nextX = aliveTree.x + dx[j];
                        if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) continue;
                        trees.add(new Tree(nextY, nextX, 1));
                    }
                }
                trees.add(aliveTree);
            }
            // 겨울
            // System.out.println("day : " + i + ", water status");
            for (int j = 0; j < N; j++) {
                for (int m = 0; m < N; m++) {
                    board[j][m] += water[j][m];
                }
            }
        }

        System.out.println(trees.size());
    }

    static class Tree {
        int y;
        int x;
        int age;

        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        public void old() {
            this.age = this.age + 1;
        }
    }
}
