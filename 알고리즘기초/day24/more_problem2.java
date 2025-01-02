import java.util.*;

public class more_problem2 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(solution(id_list, report, k));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, String[]> reportMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (String id : id_list) {
            indexMap.put(id, index);
            index++;
        }

        for (String rep : report) {
            String[] repArray = rep.split(" ");
            if (!reportMap.containsKey(repArray[1])) {
                reportMap.put(repArray[1], new String[]{repArray[0]});
                continue;
            }
            String[] result = reportMap.get(repArray[1]);
            boolean flag = false;
            for (String s : result) {
                if (s.equals(repArray[0])){
                    flag = true;
                }
            }
            if(flag) continue;
            String[] addResult = new String[result.length + 1];
            System.arraycopy(result, 0, addResult, 0, result.length);
            addResult[result.length] = repArray[0];
            reportMap.put(repArray[1], addResult);
        }

        int[] answer = new int[id_list.length];
        for (String[] value : reportMap.values()) {
            if (value.length >= k) {
                for (int i = 0; i < value.length; i++) {
                    answer[indexMap.get(value[i])] += 1;
                }
            }
        }
        return answer;
    }
}
