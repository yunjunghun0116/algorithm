public class problem3 {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i= 0; i < numLog.length-1;i++){
            int preNum = numLog[i];
            int nextNum = numLog[i+1];
            int changeNum = nextNum - preNum;
            switch (changeNum){
                case 1:
                    answer+="w";
                    break;
                case -1:
                    answer+="s";
                    break;
                case 10:
                    answer+="d";
                    break;
                case -10:
                    answer+="a";
                    break;
            }
        }
        return answer;
    }
}
