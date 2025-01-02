import java.util.*;
import java.util.stream.Stream;

public class problem1 {
    public static void main(String[] args) {
        String[] result = solution(new String[]{"XYZ", "XWY", "WXA"},new int[]{2,3,4});
        for(String str : result){
            System.out.println(str);
        }
    }
    public static String[] solution(String[] orders, int[] course) {
        Map<String,Integer> resultMap = new HashMap<>();
        Map<Integer,String[]> maxResultMap = new HashMap<>();
        Map<Integer,Integer> maxValueMap = new HashMap<>();
        for(int size : course){
            maxValueMap.put(size,0);
        }

        List<String> result = new ArrayList<>();
        for(String order:orders){
            char[] orderCharArray = order.toCharArray();
            Arrays.sort(orderCharArray);

            List<String> keyList = getKeyList(String.valueOf(orderCharArray),course);
            for(String key : keyList){
                if(resultMap.containsKey(key)){
                    int value = resultMap.get(key);
                    resultMap.put(key,value+1);
                    continue;
                }
                resultMap.put(key,1);
            }
        }

        resultMap.entrySet().forEach(
                entry -> {
                    int size = entry.getKey().length();
                    int count = entry.getValue();
                    if(count<2) return;
                    if(maxValueMap.get(size) < count){
                        maxValueMap.put(size,count);
                        maxResultMap.put(size,new String[]{entry.getKey()});
                        return;
                    }
                    if(maxValueMap.get(size) == count){
                        String[] value = maxResultMap.get(size);
                        maxResultMap.put(size, Stream.concat(Arrays.stream(value), Arrays.stream((new String[]{entry.getKey()}))).toArray(String[]::new));
                    }
                }
        );

        maxResultMap.entrySet().forEach(
                entry->{
                    String[] value = entry.getValue();
                    for(String s : value){
                        result.add(s);
                    }
                }
        );

        Collections.sort(result);
        return result.toArray(String[]::new);
    }

    public static List<String> getKeyList(String order,int[] course) {
        List<String> result = new ArrayList<>();
        for(int courseLength : course){
            if(order.length() < courseLength) break;
            combination(result,"",-1,courseLength,order);
        }
        return result;
    }

    public static void combination(List result, String preStr, int lastNumber, int length, String str) {
        if (preStr.length() == length) {
            result.add(preStr);
            return;
        }
        for (int i = lastNumber + 1; i < str.length(); i++) {
            combination(result, preStr + str.charAt(i), i, length, str);
        }
    }
}
