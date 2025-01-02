public class problem3 {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int size = 0;
        for(boolean value : finished){
            if(!value)size++;
        }
        String[] answer = new String[size];
        int index = 0;
        for(int i = 0; i < finished.length; i++){
            if(finished[i]) continue;
            answer[index++] = todo_list[i];
        }
        return answer;
    }
}
