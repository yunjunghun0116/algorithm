public class problem3 {


    public static void main(String[] args) {
        int result1 = solution(0, 0, 0, 23, 59, 59);
        int result2 = solution(1, 5, 5, 1, 5, 6);
        int result3 = solution(0, 0, 0, 0, 0, 1);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        int result4 = solution(0, 6, 1, 0, 6, 6);
        int result5 = solution(0, 0, 0, 23, 0, 0);
        System.out.println(result4);
        System.out.println(result5);


        int result6 = solution(11, 59, 59, 12, 0, 0);
        int result7 = solution(12, 59, 59, 13, 0, 0);
        int result8 = solution(13, 59, 59, 14, 0, 0);
        int result9 = solution(14, 59, 59, 15, 0, 0);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
    }

    static double hourMoveDig = 1 / 120.0;
    static double minuteMoveDig = 1 / 10.0;
    static double secondMoveDig = 6;//1초 6도 -> 60초면 360도 분침 : 1초에 몇도 움직임? 60분에 360도 1분에 6도 60초에 6도 1초에 0.1도;, 1시간에 360도 12시간에 360도 1시간에 30도 60분에 30도 1분에 0.5도 60초 0.5도 6초에 0.05도 30초에 0.25도 1/

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime = (s1 + m1 * 60 + h1 * 60 * 60);
        int endTime = (s2 + m2 * 60 + h2 * 60 * 60);
        for (int i = 0; i < endTime - startTime; i++) {
            if(startTime+i >= 12*60*60){
                answer += calculation(startTime+i-12*60*60);
            }else{
                answer += calculation(startTime + i);
            }
        }
        if (startTime < 12 * 60 * 60 && endTime > 12 * 60 * 60) answer--;

        if (m2 == 0 && s2 == 0) {
            if(h2!=12){// 12시에 마무리되는순간은 이미 시침-초침의 만남으로 체크되어있어 여기서 체크시 한번 더 체크하는것임.
                answer++;
            }
        }
        return answer;
    }

    public static int calculation(int sec) {
        double secDig = (sec % 60) * secondMoveDig;
        double nextSecDig = secDig+ secondMoveDig;
        double minDig = (sec % 3600) * minuteMoveDig;
        double nextMinDig = minDig + minuteMoveDig;
        double hourDig = (sec % (60 * 60 * 12)) * hourMoveDig;
        double nextHourDig = hourDig+hourMoveDig;

        boolean isMin = secDig <= minDig && nextSecDig >= nextMinDig;
        boolean isHour = secDig <= hourDig && nextSecDig >= nextHourDig;
        int answer = 0;
        if (isMin) answer++;
        if (isHour) answer++;

        if (isMin && isHour) {
            if (minDig <= hourDig && nextMinDig >= nextHourDig) {
                return 1;
            }
        }
        return answer;
    }
}
