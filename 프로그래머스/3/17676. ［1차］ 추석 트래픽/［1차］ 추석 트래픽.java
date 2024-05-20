import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    
    public int solution(String[] lines) {
        setLines(lines);
        int result = find();
        return result;
    }
    
    public int find(){
        int result = 1;
        for(int i = 0; i < list.size()-1 ; i++){
            int count = 1;
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i)[1] + 1000 > list.get(j)[0]){
                    count ++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
    
    public void setLines(String[] lines){
        for(String line : lines){
            String[] lineInfo = line.split(" ");
            int endTime = getTime(lineInfo[1]);
            int duration = getDuration(lineInfo[2]);
            int startTime = endTime - duration + 1;
            
            int[] process = new int[]{startTime,endTime};
            list.add(process);
        }
        
        // Collections.sort(list,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
    }
    
    public int getTime(String time){
        String[] times = time.split(":");
        
        double hour = Double.parseDouble(times[0]);
        double minute = Double.parseDouble(times[1]);
        double sec = Double.parseDouble(times[2]); 
        double result = (hour*3600+minute*60+sec)*1000;
        
        return (int)result;
    }
    
    public int getDuration(String duration){
        String time = duration.replace("s","");
        double dur = Double.parseDouble(time)*1000;
        return (int) dur;
    }
}