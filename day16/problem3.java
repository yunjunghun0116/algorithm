public class problem3 {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            if(i%2==0){
                answer[i] = strArr[i].toLowerCase();
                continue;
            }
            answer[i] = strArr[i].toUpperCase();
        }
        return answer;
    }
}
