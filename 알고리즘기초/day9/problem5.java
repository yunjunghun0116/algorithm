public class problem5 {
    public int solution(String my_string, String is_suffix) {
        boolean answer = false;
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.substring(i).equals(is_suffix)){
                answer = true;
                break;
            }
        }
        return answer?1:0;

    }
}
