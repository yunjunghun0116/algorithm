import java.util.*;

public class bible1 {
    public int[] solution(int[] numlist, int n) {
        int[] answer = numlist;
        for(int i = 0; i < answer.length; i++){
            for(int j = i+1; j < answer.length; j++){
                if(Math.abs(answer[i]-n)>Math.abs(answer[j]-n)){
                    int swap = answer[i];
                    answer[i] = answer[j];
                    answer[j] = swap;
                }
                if(Math.abs(answer[i]-n)==Math.abs(answer[j]-n)){
                    if(answer[j]>answer[i] ){
                        int swap = answer[i];
                        answer[i] = answer[j];
                        answer[j] = swap;
                    }
                }
            }
        }

        return answer;
    }

    public int[] solution2(int[] numList, int n) {
        return Arrays.stream(numList)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
