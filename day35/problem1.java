import java.util.*;

public class problem1 {
    public static void main(String[] args) {
        int[][] result = solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
    }

    public static int[][] solution(int[][] nodeinfo) {

        List<int[]> nodeList = new ArrayList<>();

        int count = 1;

        for (int[] node : nodeinfo) {
            nodeList.add(new int[]{node[0], node[1], count++});
        }
        if (nodeList.isEmpty()) return new int[][]{};

        Collections.sort(nodeList, (a, b) -> b[1] - a[1]);

        Queue<int[]> queue = new LinkedList();

        for (int i = 0; i < nodeList.size(); i++) {
            queue.offer(nodeList.get(i));
        }
        int[] rootData = queue.poll();
        Node root = new Node(rootData[2], rootData[0]);

        while (!queue.isEmpty()) {
            int[] pollData = queue.poll();
            root = add(root, pollData[2], pollData[0]);
        }
        int[] preOrderResult = preOrder(root);

        int[] postOrderResult =postOrder(root);

        return new int[][]{preOrderResult,postOrderResult};
    }

    public static Node add(Node preNode, int count, int newValue) {
        if (newValue < preNode.value) {
            if (preNode.left == null) {
                preNode.left = new Node(count, newValue);
                return preNode;
            }
            preNode.left = add(preNode.left, count, newValue);
            return preNode;
        }
        if (preNode.right == null) {
            preNode.right = new Node(count, newValue);
            return preNode;
        }
        preNode.right = add(preNode.right, count, newValue);
        return preNode;
    }

    public static void printNode(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            Node pollNode = nodeQueue.poll();
            System.out.print(pollNode.number + " ");
            if (pollNode.left != null) {
                nodeQueue.add(pollNode.left);
            }
            if (pollNode.right != null) {
                nodeQueue.add(pollNode.right);
            }
        }
    }

    public static int[] preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node popData = nodeStack.pop();
            result.add(popData.number);
            if (popData.right != null) {
                nodeStack.push(popData.right);
            }
            if (popData.left != null) {
                nodeStack.push(popData.left);
            }
        }

//        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] postOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node popData = nodeStack.pop();
            result.add(popData.number);
            if (popData.left != null) {
                nodeStack.push(popData.left);
            }
            if (popData.right != null) {
                nodeStack.push(popData.right);
            }
        }

        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Node {
        Integer number;
        Integer value;
        Node left;
        Node right;

        public Node(Integer number, Integer value) {
            this.number = number;
            this.value = value;
        }
    }
}
