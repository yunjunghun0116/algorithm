import java.util.*;

public class problem1 {
    public int solution(int n, int[][] computers) {
        Map<Integer,List<Integer>> edgeMap = new HashMap<>();
        for(int i = 0; i < n ; i++){
            edgeMap.put(i,new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            List<Integer> integers = edgeMap.get(i);
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    if(integers.contains(j)) continue;
                    integers.add(j);
                }
            }
            edgeMap.put(i,integers);
        }

        boolean[] visited = new boolean[n];

        int answer = 0;

        Stack<Integer> computerStack = new Stack<>();

        while(!finish(visited)){
            for(int i = 0; i < n; i++){
                if(visited[i])continue;
                computerStack.push(i);
                answer++;
                visited[i] = true;
                break;
            }

            while(!computerStack.isEmpty()){
                int poppedComputer = computerStack.pop();
                for(int i : edgeMap.get(poppedComputer)){
                    if(visited[i]) continue;
                    visited[i]= true;
                    computerStack.push(i);
                }
            }
        }
        return answer;
    }

    boolean finish(boolean[] visited){
        for(boolean value : visited){
            if(!value) return false;
        }
        return true;
    }
}
