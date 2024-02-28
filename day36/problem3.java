import java.util.*;

public class problem3 {
    public int solution(int n, int[][] edge) {
        int[] answer = new int[n+1];
        Arrays.fill(answer,Integer.MAX_VALUE);

        Stack<int[]> destStack = new Stack<>();
        Map<Integer,List<Integer>> edgeMap = new HashMap<>();

        for(int[] ed : edge){
            List<Integer> destList;
            if(edgeMap.containsKey(ed[0])){
                destList = edgeMap.get(ed[0]);
            }else{
                destList = new ArrayList<>();
            }
            destList.add(ed[1]);
            edgeMap.put(ed[0],destList);

            List<Integer> desList;
            if(edgeMap.containsKey(ed[1])){
                desList = edgeMap.get(ed[1]);
            }else{
                desList = new ArrayList<>();
            }
            desList.add(ed[0]);
            edgeMap.put(ed[1],desList);
        }

        answer[0] = 0;
        answer[1] = 0;
        // node / dist
        destStack.push(new int[]{1,0});

        while(!destStack.isEmpty()){
            // node / dist
            int[] popNode = destStack.pop();
            List<Integer> destList = edgeMap.get(popNode[0]);
            for(int dest : destList){
                int dist = popNode[1]+1;
                if(dist < answer[dest]){
                    answer[dest] = dist;
                    destStack.push(new int[]{dest,dist});
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int maxCount = 0;
        for(int i = 0; i <= n;i++){
            if(answer[i] > maxValue){
                maxValue = answer[i];
                maxCount = 1;
                continue;
            }
            if(answer[i] == maxValue){
                maxCount++;
            }
        }

        return maxCount;
    }
}
