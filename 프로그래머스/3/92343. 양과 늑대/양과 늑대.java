import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int[][] answer = new int[info.length][2];

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            if (edgeMap.containsKey(edge[0])) {
                List<Integer> destinationList = edgeMap.get(edge[0]);
                destinationList.add(edge[1]);
                edgeMap.put(edge[0], destinationList);
                continue;
            }
            List<Integer> destinationList = new ArrayList<>();
            destinationList.add(edge[1]);
            edgeMap.put(edge[0], destinationList);
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        Node start = new Node(0, visited, new int[]{1, 0});
        queue.add(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Integer> destList = new ArrayList<>();
            for (int i = 0; i < info.length; i++) {
                if (node.visited[i]) {
                    if (edgeMap.containsKey(i)) {
                        destList.addAll(edgeMap.get(i));
                    }
                }
            }
            // node.visited + destNode => 다음 queue에 들어갈 값

            for (int dest : destList) {
                int[] countArr = node.sheepWolfCount.clone();
                if (info[dest] == 0) {
                    countArr[0] = countArr[0] + 1;
                } else {
                    countArr[1] = countArr[1] + 1;
                }

                if (countArr[0] <= countArr[1]) continue;

                boolean[] visitedNode = node.visited.clone();
                if(!visitedNode[dest]){
                    visitedNode[dest] = true;
                    queue.add(new Node(dest, visitedNode, countArr));
                }
                if (countArr[0] > answer[dest][0]) {
                    answer[dest][0] = countArr[0];
                    answer[dest][1] = countArr[1];
                }

            }

        }

        int maxCount = 0;
        for (int[] result : answer) {
            maxCount = Math.max(maxCount, result[0]);
        }


         return Math.max(maxCount-1, 1);
    }
    
    static class Node {
        int value;
        boolean[] visited;
        int[] sheepWolfCount;

        public Node(int value, boolean[] visited, int[] sheepWolfCount) {
            this.visited = visited;
            this.sheepWolfCount = sheepWolfCount;
            this.value = value;
        }
    }
}