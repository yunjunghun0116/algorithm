import java.util.Arrays;

public class problem1 {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        int[] result = new int[strArr.length];
        int index = 0;
        for(String str : strArr){
            result[index++] = Integer.parseInt(str);
        }

        Arrays.sort(result);

        String answer = result[0] + " " + result[result.length-1];
        return answer;
    }
}
