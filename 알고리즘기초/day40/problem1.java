import java.util.*;

public class problem1 {

    public static void main(String[] args) {
        int[] result = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        // fees : 기본시간 기본요금 단위시간(분) 단위요금
        // records : hh:mm 차량번호 IN/OUT
        // 분으로만 지정, 만약 출차시 key를 지우고 carMinuteMap 으로 데이터 이동
        Map<Integer, Integer> inCarMap = new HashMap<>();

        Map<Integer, Integer> carMinuteMap = new HashMap<>();

        Set<Integer> carSet = new HashSet<>();

        for (String record : records) {
            String[] information = record.split(" ");
            int time = Integer.parseInt(information[0].split(":")[0]) * 60 + Integer.parseInt(information[0].split(":")[1]);
            int carNumber = Integer.parseInt(information[1]);
            String inOutInformation = information[2];

            carSet.add(carNumber);

            if (inOutInformation.equals("IN")) {
                inCarMap.put(carNumber, time);
            }
            if (inOutInformation.equals("OUT")) {
                int preTime = inCarMap.get(carNumber);
                if (carMinuteMap.containsKey(carNumber)) {
                    int carMinute = carMinuteMap.get(carNumber);
                    carMinute += time - preTime;
                    carMinuteMap.put(carNumber, carMinute);
                } else {
                    int value = time - preTime;
                    carMinuteMap.put(carNumber, value);
                }
                inCarMap.remove(carNumber);
            }
        }

        if (!inCarMap.keySet().isEmpty()) {
            int time = 23 * 60 + 59;
            for (Integer key : inCarMap.keySet()) {
                int preTime = inCarMap.get(key);
                if (carMinuteMap.containsKey(key)) {
                    int carMinute = carMinuteMap.get(key);
                    carMinute += time - preTime;
                    carMinuteMap.put(key, carMinute);
                } else {
                    int value = time - preTime;
                    carMinuteMap.put(key, value);
                }
            }
        }

        List<Integer> carList = new ArrayList<>();
        carList.addAll(carSet);
        carList.sort((a, b) -> a - b);

        List<Integer> answer = new ArrayList<>();
        for (int carNumber : carList) {
            int totalMinute = carMinuteMap.get(carNumber);
            if (totalMinute > fees[0]) {
                int result = fees[1] + ((totalMinute - fees[0]) / fees[2]) * fees[3];
                if ((totalMinute - fees[0]) % fees[2] != 0) {
                    result += fees[3];
                }
                answer.add(result);
                continue;
            }
            answer.add(fees[1]);
        }

        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        for (int value : result) {
            System.out.println(value);
        }
        return result;
    }
}
