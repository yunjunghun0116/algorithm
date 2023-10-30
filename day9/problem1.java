public class problem1 {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        for(String intStr : intStrs){
            String subStr = intStr.substring(s,s+l);
            int value = Integer.parseInt(subStr);
            if(value>k){
                int[] subList  = new int[answer.length+1];
                System.arraycopy(answer,0,subList,0,answer.length);
                subList[answer.length] = value;
                answer = subList;
            }
        }
        return answer;
    }
}
