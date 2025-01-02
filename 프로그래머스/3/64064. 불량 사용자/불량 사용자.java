import java.util.*;

class Solution {
    Set<String> resultSet = new HashSet<>();
     Map<String,List<String>> banUserMap = new HashMap<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        // * => [0-9a-z] 로 치환하기
        
        for(String banTxt : banned_id){
            String txt = banTxt.replaceAll("\\*","\\[0-9a-z\\]");
            List<String> userList = new ArrayList<>();
            banUserMap.put(banTxt,userList);
            
            for(String user : user_id){
                if(user.matches(txt)){
                    List<String> list = banUserMap.get(banTxt);
                    list.add(user);
                    banUserMap.put(banTxt,list);
                }
            }
        }
        List<String> userList = new ArrayList<>();
        dfs(userList,0,banned_id);
    
        
        return resultSet.size();
    }
    
    public void dfs(List<String> currentUsers,int currentIndex,String[] banned_id){
        if(currentIndex==banned_id.length){
            String[] result = currentUsers.toArray(String[]::new);
            Arrays.sort(result);
            
            resultSet.add(String.join("", result));
            return;
        }
        List<String> nextUserList = banUserMap.get(banned_id[currentIndex]);
        for(String nextUser : nextUserList){
            if(currentUsers.contains(nextUser))continue;
            currentUsers.add(nextUser);
            dfs(currentUsers,currentIndex+1,banned_id);
            currentUsers.remove(nextUser);
        }
    }
}