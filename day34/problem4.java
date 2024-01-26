import java.util.LinkedList;
import java.util.Queue;

public class problem4 {

    public static void main(String[] args) {
        // 이진트리로 min / max 로 처리하기

        Node root = new Node(15,null);

        for (int i = 1; i < 10; i++) {
            put(root, i);
        }
        int minValue = pollMin(root);
        int maxValue = pollMax(root);

        System.out.println(minValue);
        System.out.println(maxValue);
        printAll(root);
    }

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;


        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }


    }

    public static void put(Node node, int newValue) {
        if (node.left == null && node.right == null) {
            if (newValue <= node.value) {
                node.left = new Node(newValue, node);
                return;
            }
            node.right = new Node(newValue, node);
            return;
        }
        if (node.right == null) {
            if (newValue <= node.value) {
                put(node.left, newValue);
                return;
            }
            node.right = new Node(newValue, node);
            return;
        }
        if (node.left == null) {
            if (newValue <= node.value) {
                node.left = new Node(newValue, node);
                return;
            }
            put(node.right, newValue);
            return;
        }

        if (newValue <= node.value) {
            put(node.left, newValue);
            return;
        }
        put(node.right, newValue);
    }

    public static int pollMin(Node node) {
        if (node == null) return 0;
        if (node.left == null) {
            node.parent.left = node.right;
            return node.value;
        }

        return pollMin(node.left);
    }

    public static int pollMax(Node node) {
        if (node == null) return 0;
        if (node.right == null) {
            node.parent.right = node.left;
            return node.value;
        }

        return pollMin(node.right);
    }

    public static void printAll(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
