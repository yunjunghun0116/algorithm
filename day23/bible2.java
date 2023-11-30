import java.util.Arrays;
import java.util.Comparator;

public class bible2 {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int index = 0;
        for(int[] sc : score){
            answer[index++] = sc[0]+sc[1];
        }
        int[] sumRank = Arrays.stream(answer).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] result = new int[score.length];
        for(int i = 0; i < answer.length ;i++){
            for(int j = 0; j < answer.length; j++){
                if(answer[i] == sumRank[j]){
                    result[i] = j+1;
                    break;
                }
            }
        }
        return result;
    }
}
