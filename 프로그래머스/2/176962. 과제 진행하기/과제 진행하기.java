import java.util.*;


class Solution {
    public String[] solution(String[][] plans) {
        Map<Integer,String> planNameMap = new HashMap<>();
        //start, end, index
        int index = 0;
        List<int[]> planList = new ArrayList<>();
        
        for(String[] plan : plans){
            String[] startTimeStr = plan[1].split(":");
            
            int startTime = Integer.parseInt(startTimeStr[0])*60+Integer.parseInt(startTimeStr[1]);
            int duration = Integer.parseInt(plan[2]);
            planNameMap.put(index,plan[0]);
            planList.add(new int[]{startTime,startTime+duration,index});
            index++;
        }
        
        planList.sort((a,b)->a[0]-b[0]);
        for(int[] check : planList){
            System.out.println("start : "+check[0]+", end : "+check[1]+", name : "+planNameMap.get(check[2]));
        }
        
        Queue<int[]> planQueue = new LinkedList<>();
        Stack<int[]> leavePlanStack = new Stack<>(); // 남은시간, index
        for(int[] arr : planList){
            planQueue.add(arr);
        }
        List<String> result = new ArrayList<>();
        int[] currentPlan = planQueue.poll();
        //start, end, index
        while(!planQueue.isEmpty()){
            int[] plan = planQueue.poll();
            
            if(currentPlan[1]<=plan[0]){
                result.add(planNameMap.get(currentPlan[2]));
                int remainTime = plan[0]-currentPlan[1];
                while(remainTime>=0&&!leavePlanStack.isEmpty()){
                   int[] leavePlan =  leavePlanStack.pop();
                    if(leavePlan[0]<=remainTime){
                        result.add(planNameMap.get(leavePlan[1]));
                        remainTime-=leavePlan[0];
                    }else{
                        leavePlanStack.push(new int[]{leavePlan[0]-remainTime,leavePlan[1]});
                        remainTime = -1;
                    }
                }
            }else{
                leavePlanStack.push(new int[]{currentPlan[1]-plan[0],currentPlan[2]});
            }
            currentPlan = plan;
        }
        
        result.add(planNameMap.get(currentPlan[2]));
       
        while(!leavePlanStack.isEmpty()){
                   int[] leavePlan =  leavePlanStack.pop();
                    result.add(planNameMap.get(leavePlan[1]));
        
                }
        
        return result.toArray(String[]::new);
    }
}