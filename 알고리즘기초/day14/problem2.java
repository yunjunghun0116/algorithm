public class problem2 {
    public String[] solution(String[] names) {
        String[] answer = new String[(names.length-1)/5+1];
        for(int i = 0; i<names.length; i+=5){
            answer[i/5] = names[i];
        }
        return answer;
    }
}
