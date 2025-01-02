import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] fighters = new int[n+1][n+1];
        
        for(int[] result : results){
            fighters[result[0]][result[1]] = 1;
            fighters[result[1]][result[0]] = -1;
        }
        
        for(int i = 1; i < n+1; i++){
            int[] winLose = fighters[i];
            // i가 j에게 졌으면 => -1이면 그 아래 모든놈들은 다 -1이 된다.
            List<Integer> loseFighterList = new ArrayList<>();
            for(int j = 1; j < n+1; j++){
                if(winLose[j] == -1){// 승자들의 Number
                    loseFighterList.add(j);
                }
            }
            
            for(int j = 1; j < n+1; j++){
                // i가 이긴 놈들은 모두 -1로 바꿔줘야하기때문
                if(winLose[j]==1){ 
                    for(int index : loseFighterList){
                        fighters[index][j] = 1;
                        fighters[j][index] = -1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i < n+1; i++){
            int sum = 0;
            for(int j = 1; j < n+1; j++){
                if(fighters[i][j]==0) continue;
                sum++;
            }
            if(sum >= n-1) answer++;
        }
        
        
        
        return answer;
    }
}