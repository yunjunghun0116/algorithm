import java.util.Arrays;

public class bible3 {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] checkArr = new int[201];

        for(int[] line : lines){
            int s = line[0]+100;
            int e = line[1]+100;
            for(int i = s ;i <= e; i++){
                checkArr[i] += 1;
            }
        }

        for(int i : checkArr){
            if(i>=2) answer++;
        }

        return answer;

    }
}
