import java.util.*;

public class problem2 {
    //정확성: 76.5
    //합계: 76.5 / 100.0
    // 시간 뿐만 아니라 메모리사용량도 줄여야할듯?

    public static  void main(String[] args) {
        System.out.println(solution(new int[]{100,180,360,100,270}));
    }

    public static long solution(int[] weights) {

        Map<Integer, List<Integer>> weightMap = new HashMap<>();
        int[] multiple = new int[]{2,3,4};
        int index = 0;
        for(int weight : weights){
            for(int multiply : multiple){
                int key = multiply * weight;
                if(weightMap.containsKey(key)){
                    List<Integer> indexList = weightMap.get(key);
                    indexList.add(index);
                    weightMap.put(key,indexList);
                    continue;
                }

                List<Integer> newList = new ArrayList<>();
                newList.add(index);
                weightMap.put(key,newList);
            }
            index++;
        }
        long answer = 0;

        Map<Integer,List<Integer>> graphMap = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> entry: weightMap.entrySet()){

            if(entry.getValue().size() >= 2){
               List<Integer> indexList = entry.getValue();
               for(int i = 0; i < indexList.size(); i++){
                   for(int j = i+1; j < indexList.size(); j++){
                       int start = indexList.get(i);
                       int end = indexList.get(j);

                       if(graphMap.containsKey(start)){
                           List<Integer> endList = graphMap.get(start);
                           if(!endList.contains(end)){
                               endList.add(end);
                           }

                           graphMap.put(start,endList);
                           continue;
                       }
                       List<Integer> endList = new ArrayList<>();
                       endList.add(end);
                       graphMap.put(start,endList);
                   }
               }
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry: graphMap.entrySet()){
            answer += entry.getValue().size();
        }

        return answer;
    }
}
