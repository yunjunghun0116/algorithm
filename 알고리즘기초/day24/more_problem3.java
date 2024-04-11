import java.util.*;

public class more_problem3 {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> nameMap = new HashMap();
        Map<Integer,String> rankingMap = new HashMap();
        int ranking = 1;
        for(String player : players){
            nameMap.put(player,ranking);
            rankingMap.put(ranking,player);
            ranking++;
        }

        for(String calling : callings){
            int rank = nameMap.get(calling);
            int swapRank = rank -1;
            String swapCalling = rankingMap.get(swapRank);

            nameMap.put(calling,swapRank);
            nameMap.put(swapCalling,rank);
            rankingMap.put(swapRank,calling);
            rankingMap.put(rank,swapCalling);
        }

        List<String> result = new ArrayList();
        int resultRank = 1;
        for(int i = 0; i < players.length; i++){
            result.add(rankingMap.get(resultRank++));
        }

        return result.toArray(String[]::new);
    }
}
