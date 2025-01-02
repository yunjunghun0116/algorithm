public class problem1 {
    public int solution(String[] order) {
        int answer = 0;
        for(String coffee : order){
            if(coffee.contains("latte")){
                answer+=5000;
                continue;
            }
            answer+=4500;
        }
        return answer;
    }
}
