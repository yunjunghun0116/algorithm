import java.util.*;

public class problem1 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }

    public static int solution(String[][] book_time) {
        Arrays.sort(book_time, Comparator.comparingInt(time -> getMinute(time[0])));

        List<Integer> roomTime = new ArrayList<>();

        for (String[] time : book_time) {
            if (roomTime.isEmpty()) {
                roomTime.add(getMinute(time[1])+10);
                continue;
            }
            boolean findRoom = false;
            int minEndTime = Integer.MAX_VALUE;
            int index = Integer.MIN_VALUE;
            for (int i = 0; i < roomTime.size(); i++) {
                if (roomTime.get(i) <= getMinute(time[0])) {
                    if (!findRoom) {
                        findRoom = true;
                        minEndTime = roomTime.get(i);
                        index = i;
                        continue;
                    }
                    if(minEndTime <= roomTime.get(i)){
                        continue;
                    }
                    minEndTime =  roomTime.get(i);
                    index = i;
                }
            }

            if(findRoom){
                roomTime.remove(index);
                roomTime.add(index,getMinute(time[1])+10);
                continue;
            }
            roomTime.add(getMinute(time[1])+10);
        }
        return roomTime.size();
    }

    public static int getMinute(String time) {
        int result = 0;
        String[] timeArr = time.split(":");
        result += Integer.parseInt(timeArr[0]) * 60;
        result += Integer.parseInt(timeArr[1]);
        return result;
    }
}
