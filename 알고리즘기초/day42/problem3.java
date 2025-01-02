import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem3 {
    List<Integer> busList = new ArrayList<>();
    Map<Integer, Integer> remainSeatMap = new HashMap<>();
    int lastArriveTime = 0;

    public String solution(int n, int t, int m, String[] timetable) {
        // 09:00부터 09:00 + t*(n-1) 분까지 t분마다 셔틀 도착하며
        // 매 셔틀에는 최대 m명만 탑승가능
        // 어떤 팀이 몇시에 셔틀 대기열에 오는지
        lastArriveTime = 540 * t * (n - 1);
        for (int i = 0; i < n; i++) {
            int key = 540 + t * i;
            busList.add(key);
            remainSeatMap.put(key, m);
        }
        int lastTime = busList.get(busList.size() - 1);
        int hour = lastTime / 60;
        int minute = lastTime % 60;
        String hourStr = "";
        String minuteStr = "";
        if (hour >= 10) {
            hourStr = Integer.toString(hour);
        } else {
            hourStr = "0" + hour;
        }
        if (minute >= 10) {
            minuteStr = minuteStr + "";
        } else {
            minuteStr = "0" + minuteStr.toString();
        }
        return hourStr + ":" + minuteStr;
    }

    public int getTimes(String str) {
        String[] timeStr = str.split(":");
        int result = 0;
        result += Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);
        return result;
    }

    public void takeBus(int n, int t, int time) {
        for (int busTime : busList) {
            if (busTime >= time && remainSeatMap.containsKey(busTime)) {
                int count = remainSeatMap.get(busTime);
                if (count == 1) {
                    remainSeatMap.remove(busTime);
                    busList.remove(busTime);
                } else {
                    remainSeatMap.put(busTime, count - 1);
                }
                return;
            }
        }

    }
}
