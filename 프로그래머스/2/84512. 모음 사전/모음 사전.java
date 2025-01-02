import java.util.*;

class Solution {
    Queue<String> strQueue = new LinkedList<>();
    char[] charArr = new char[]{'A','E','I','O','U'};
    int count = 0;
    Map<String,Integer> result = new HashMap<>();
    public int solution(String word) {
    
        
        dfs("");
        
        
        return result.get(word);
    }
    public void dfs(String currentWord){
        result.put(currentWord,count++);
        if(currentWord.length()==5) return;
        for(int i = 0;i < 5; i++){
            dfs(currentWord+charArr[i]);
        }
    }
}