import java.util.*;

public class problem4 {

    public static void main(String[] args) {
        int result = solution(9,new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        System.out.println(result);
    }
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){
            Map<Integer,List<Integer>> map = getMap(n,i,wires);
            int difference = getDifference(n,map);
            answer = Math.min(answer,difference);
        }
        return answer;
    }

    public static Map<Integer,List<Integer>> getMap(int n,int removeIndex, int[][] wires){
        Map<Integer,List<Integer>> lineMap = new HashMap<>();

        for(int i = 1; i <=n; i++){
            lineMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < wires.length; i++){
            if(i == removeIndex) continue;
            int[] wire = wires[i];
            List<Integer> dst1 = lineMap.get(wire[0]);
            dst1.add(wire[1]);
            lineMap.put(wire[0], dst1);

            List<Integer> dst2 = lineMap.get(wire[1]);
            dst2.add(wire[0]);
            lineMap.put(wire[1], dst2);
        }

        return lineMap;
    }

    public static int getDifference(int n, Map<Integer,List<Integer>> map){

        boolean[] visited = new boolean[n+1];

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(1);
        while (!queue.isEmpty()) {
            int pollData = queue.poll();
            List<Integer> dstList = map.get(pollData);
            if(visited[pollData]) continue;
            if(dstList==null)  continue;
            visited[pollData] = true;
            for (int dst : dstList) {
                if(visited[dst]) continue;
                queue.add(dst);
            }
        }

        int booleanSize = 0;
        for(boolean boolValue : visited){
            if(boolValue) booleanSize++;
        }

        return Math.abs(n-(2*booleanSize));
    }
}
