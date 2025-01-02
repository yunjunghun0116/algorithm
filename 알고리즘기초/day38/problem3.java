import java.util.*;

public class problem3 {

    static List<String> resultList = new ArrayList<>();
    static List<List<Integer>> teamMemberList = new ArrayList<>();

    public int solution(int[] sales, int[][] links) {

        // sales : i-1 로 접근
        Map<Integer,List<Integer>>  teamList = new HashMap<>();

        for(int[] link : links){
            if(teamList.containsKey(link[0])){
                List<Integer> list = teamList.get(link[0]);
                list.add(link[1]);
                teamList.put(link[0],list);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(link[0]);
            list.add(link[1]);
            teamList.put(link[0],list);
        }
        // list < list < integer > >
        for(Map.Entry<Integer,List<Integer>> team : teamList.entrySet()){
            teamMemberList.add(team.getValue());
        }

        findCount("");

        int min_value = Integer.MAX_VALUE;
        for(String str : resultList){
            List<Integer> memberList = new ArrayList<>();
            int memberSales = 0;
            for(int i = 0; i < str.length(); i++){
                int index = Integer.parseInt(String.valueOf(str.charAt(i)));
                int member = teamMemberList.get(i).get(index);
                if (memberList.contains(member)) continue;
                memberList.add(member);
                memberSales += sales[member-1];
            }
            min_value = Math.min(min_value,memberSales);

        }
        return min_value;
    }

    public void findCount(String currentStr){
        if(teamMemberList.size() == currentStr.length()){
            resultList.add(currentStr);
            return;
        }
        for(int i =0 ; i < teamMemberList.get(currentStr.length()).size(); i++){
            findCount(currentStr+i);
        }
    }
}
