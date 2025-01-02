public class problem4 {
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
        for(int[] query : queries){
            String tempStr = "";
            for(int i = query[1]; i >= query[0]; i--){
                tempStr += answer.charAt(i);
            }
            answer = answer.substring(0,query[0]) + tempStr + answer.substring(query[1]+1);
        }

        return answer;
    }
}
