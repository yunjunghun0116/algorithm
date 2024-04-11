import java.util.*;

public class problem5 {
    public static void main(String[] args) {
        //solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}});

        //solution(new String[][]{{"ICN", "JFK"},{"ICN", "AAD"},{"JFK", "ICN"}});

        solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"BOO", "ICN"}, {"ICN", "BOO"}, {"COO", "BOO"}});


    }

    public static String[] solution(String[][] tickets) {

        Stack<String[]> stringStack = new Stack<>();
        Set<String> airportSet = new HashSet<>();
        Map<String, List<String>> ticketMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        Map<String, Integer> duplicateTicketMap = new HashMap<>();


        for (String[] str : tickets) {
            airportSet.add(str[1]);
            if (ticketMap.containsKey(str[0])) {
                List<String> strList = ticketMap.get(str[0]);
                if (strList.contains(str[1])) {
                    String duplicateString = str[0] + " " + str[1];
                    if (duplicateTicketMap.containsKey(duplicateString)) {
                        int count = duplicateTicketMap.get(duplicateString);
                        count++;
                        duplicateTicketMap.put(duplicateString, count);
                    } else {
                        duplicateTicketMap.put(duplicateString, 2);
                    }
                }
                strList.add(str[1]);
                ticketMap.put(str[0], strList);
                continue;
            }
            List<String> strList = new ArrayList<>();
            strList.add(str[1]);
            ticketMap.put(str[0], strList);
        }

        airportSet.add("ICN");
        String start = "ICN";
        stringStack.push(new String[]{start, start});

        while (!stringStack.isEmpty()) {
            String[] popData = stringStack.pop();
            // popData : 현재 위치 / 쌓인 위치
            if (popData[1].split(" ").length > tickets.length) {
                // 만약 모두 다 지나왔다면 -> 오케이
                // 아니면 나가리
                boolean noHave = false;
                for (String str : airportSet) {
                    if (popData[1].contains(str)) {
                        continue;
                    }
                    noHave = true;
                }
                if (noHave) {
                    continue;
                }
                String testString = " " + popData[1] + " ";
                boolean canAdd = true;
                for (Map.Entry<String, Integer> entry : duplicateTicketMap.entrySet()) {
                    if (testString.split(entry.getKey()).length < entry.getValue() + 1) {
                        canAdd = false;
                    }

                }
                if (canAdd) {
                    resultList.add(popData[1]);
                }
                continue;
            }
            if (ticketMap.containsKey(popData[0])) {
                List<String> targetList = ticketMap.get(popData[0]);
                for (String str : targetList) {
                    if (popData[1].contains(popData[0] + " " + str)) {
                        if (!duplicateTicketMap.containsKey(popData[0] + " " + str)) {
                            continue;
                        }
                    }
                    stringStack.push(new String[]{str, popData[1] + " " + str});
                }
            }
        }

        if (resultList.isEmpty()) {
            System.out.println("s");
            return new String[]{};
        }

        String answer = resultList.get(0);
        for (String str : resultList) {
            answer = answer.compareTo(str) > 0 ? str : answer;
        }

        System.out.println(answer);
        return answer.split(" ");
    }
}
