import java.util.*;

class Solution {
    
    
    public String solution(int n, int t, int m, String[] timetable) {
        // 자리가 남은것들중 가장 뒤에꺼 혹은
        // 탑승자들중 제일 늦은사람 -1 시간
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = m;
        }
        int lastMemberTime = 0;
        List<Integer> timeList = new ArrayList<>();
        for(String member : timetable){
            int memberTime = getTimes(member);
            timeList.add(memberTime);
        }
        Collections.sort(timeList);
        
        for(int memberTime : timeList){
           boolean takebus = false;
            for(int i = 0; i < n; i++){
                if(memberTime <= 540+t*i && dp[i]>0){
                    takebus = true;
                    lastMemberTime = Math.max(lastMemberTime,memberTime);
                    dp[i] = dp[i]-1;
                    break;
                }
            }
        }
        
        if(dp[n-1] > 0) return getResult(540+t*(n-1));
        return getResult(lastMemberTime-1);
    }
    public int getTimes(String str){
        String[] timeStr = str.split(":");
        int result = 0;
        result += Integer.parseInt(timeStr[0])*60 + Integer.parseInt(timeStr[1]);
        return result;
    }
    public String getResult(int time){
        int hour = time/60;
        int minute = time%60;
        String result = "";
        if(hour>=10){
            result = Integer.toString(hour);
        }else{
            result = "0"+Integer.toString(hour);
        }
        result = result + ":";
        if(minute>=10){
            result = result + Integer.toString(minute);
        }else{
            result = result + "0"+Integer.toString(minute);
        }
        return result;
    }
}