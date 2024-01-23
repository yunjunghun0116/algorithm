import java.util.*;

public class problem2 {
    public static void main(String[] args) {
        int[] result = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        for(int number : result){
            System.out.println(number);
        }
    }

    public static int[] solution(String s) {
        List<int[]> intArray = getIntArray(s);
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> checkMap = new HashMap<>();

        for(int[] numberArray : intArray){
            for(int number : numberArray){
                if(checkMap.containsKey(number)) continue;
                checkMap.put(number,1);
                result.add(number);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static List<int[]> getIntArray(String s){
        String remove_s = s.substring(1,s.length()-1);
        remove_s = remove_s.replaceAll("\\},\\{","\\}split\\{");
        String[] strArr = remove_s.split("split");
        List<int[]> resultList = new ArrayList<>();

        for(String str : strArr){
            String[] arr = str.substring(1,str.length()-1).split(",");
            int[] intArr = new int[arr.length];
            for(int i = 0; i < arr.length; i++){
                intArr[i] = Integer.parseInt(arr[i]);
            }
            resultList.add(intArr);
        }

        resultList.sort(Comparator.comparing((int[] point)->point.length));
        return resultList;
    }
}
