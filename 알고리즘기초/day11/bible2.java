public class bible2 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 4; i <= n; i++ ){
            if(findNumber(i)){
                answer++;
            }
        }
        return answer;
    }
    public boolean findNumber(int n){
        int count = 0;
        int number = n;
        int divider = 2;
        while(number>=1){
            if(number == 1){
                count++;
                break;
            }
            if(count >= 3){
                return true;
            }
            if(number%divider == 0){
                number = number/divider;
                divider = 2;
                count++;
                continue;
            }
            divider++;
        }
        return count >= 3;
    }
}
