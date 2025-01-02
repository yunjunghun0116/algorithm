public class bible1 {
    public int solution(int hp) {
        int answer = 0;
        int remainedHp = hp;
        if(remainedHp>=5){
            answer+=remainedHp/5;
            remainedHp = remainedHp%5;

        }
        if(remainedHp>=3){
            answer+=remainedHp/3;
            remainedHp = remainedHp%3;
        }
        answer+=remainedHp;

        return answer;
    }
}
