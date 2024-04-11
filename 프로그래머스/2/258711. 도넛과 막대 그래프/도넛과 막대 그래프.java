import java.util.*;

class Solution {
    public static int[] solution(int[][] edges) {

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Map<Integer, List<Integer>> reversedEdgeMap = new HashMap<>();
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

            if (reversedEdgeMap.containsKey(edge[1])) {
                List<Integer> reversedDestinationList = reversedEdgeMap.get(edge[1]);

                reversedDestinationList.add(edge[0]);
                reversedEdgeMap.put(edge[1], reversedDestinationList);
                continue;
            }
            List<Integer> reversedDestinationList = new ArrayList<>();
            reversedDestinationList.add(edge[0]);
            reversedEdgeMap.put(edge[1], reversedDestinationList);
        }
        // 어디가 정점인지
        int nodeValue = 0;
        for (Map.Entry<Integer, List<Integer>> entry : edgeMap.entrySet()) {
            if (entry.getValue().size() >= 2 && !reversedEdgeMap.containsKey(entry.getKey())) {
                nodeValue = entry.getKey();
                break;
            }
        }

        List<Integer> startNodeList = edgeMap.get(nodeValue);
        edgeMap.remove(nodeValue);
        
        int[] answer = new int[3];
        for (int start : startNodeList) {
            int result = find(edgeMap, start);
            answer[result] = answer[result] + 1;
        }

        int[] result = new int[4];
        result[0] = nodeValue;
        result[1] = answer[0];
        result[2] = answer[1];
        result[3] = answer[2];
        return result;
    }

    public static int find(Map<Integer, List<Integer>> edgeMap, int start) {
        Set<Integer> pointSet = new HashSet<>();
        int lineCount = 0;

        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(start);

        while (!nodeStack.isEmpty()) {
            int nodeValue = nodeStack.pop();
            pointSet.add(nodeValue);

            if (!edgeMap.containsKey(nodeValue)) continue;

            List<Integer> destList = edgeMap.get(nodeValue);
            for (int dest : destList) {
                if(pointSet.contains(dest))continue;

                nodeStack.push(dest);
            }
        }

        for(int point : pointSet){
            if(edgeMap.containsKey(point)){
                lineCount += edgeMap.get(point).size();
            }
        }

        System.out.println(lineCount);

        if (pointSet.size() == lineCount) {
            return 0;
        }
        if (pointSet.size() == (lineCount + 1)) {
            return 1;
        }
        return 2;
    }
}