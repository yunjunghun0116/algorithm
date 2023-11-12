public class problem3 {
    public String[] solution(String[] str_list) {
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")){
                return leftSplit(str_list,i);
            }
            if(str_list[i].equals("r")){
                return rightSplit(str_list,i);
            }
        }
        String[] answer = {};
        return answer;
    }
    public String[] leftSplit(String[] str_list,int index){
        String[] answer = new String[index];
        System.arraycopy(str_list,0,answer,0,answer.length);
        return answer;
    }
    public String[] rightSplit(String[] str_list,int index){
        String[] answer = new String[str_list.length-index];
        System.arraycopy(str_list,index+1,answer,0,answer.length);
        return answer;
    }
}
