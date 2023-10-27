import java.util.Arrays;

public class bible3 {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] sortedArray = Arrays.stream(emergency).sorted().toArray();
        for(int i =0 ; i< emergency.length; i++){
            for(int j = 0; j < emergency.length; j++){
                if(emergency[i] == sortedArray[j]){
                    answer [i] =emergency.length - j;
                    break;
                }
            }
        }
        return answer;
    }
}
