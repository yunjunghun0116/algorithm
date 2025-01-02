import java.util.*;

public class problem2 {
    public String[] solution(String[] record) {

        Map<String, String> nameMap = new HashMap<>();
        List<String> logList = new ArrayList<>();

        for (String str : record) {
            String[] log = str.split(" ");
            if (log[0].equals("Enter")) {
                nameMap.put(log[1],log[2]);
                logList.add(log[0]+" "+log[1]);
                continue;
            }
            if (log[0].equals("Leave")) {
                logList.add(log[0]+" "+log[1]);
                continue;
            }
            nameMap.put(log[1],log[2]);
        }

        String[] result = new String[logList.size()];
        for(int i = 0; i < logList.size(); i++){
            String[] log = logList.get(i).split(" ");
            String name = nameMap.get(log[1])+"님이";
            String action = log[0].equals("Enter")?"들어왔습니다.":"나갔습니다.";
            result[i] = name+" "+action;
        }
        return result;
    }
}
