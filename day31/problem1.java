import java.util.*;

public class problem1 {

    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println("result = {" + result[0] + ", " + result[1] + "}");
    }

    public static int[] solution(int[] sequence, int k) {
        // 이중 포인터를 통해 시작과 끝을 매번 다르게 해주면서 값을 찾아가는 문제.
        List<int[]> answerList = new ArrayList<>();

        int start = 0;
        int end = 0;
        int value = sequence[0];

        while (start <= end) {
            if (value == k) {
                answerList.add(new int[]{start, end, value, end - start});
                if (end < sequence.length - 1) {
                    end++;
                    value +=sequence[end];
                    continue;
                }
                start++;
                value -= sequence[start-1];
                continue;
            }
            if(value < k){
                end++;
                if(end == sequence.length) break;
                value +=sequence[end];
                continue;
            }
            start++;
            value -= sequence[start-1];
        }

        Collections.sort(answerList, (int[] a, int[] b) -> a[2] != b[2] ? a[2] - b[2] : a[3] - b[3]);

        for(int[] answer : answerList){
            System.out.println("start : "+ answer[0] + ", end : "+answer[1]);
        }
        return new int[]{answerList.get(0)[0], answerList.get(0)[1]};
    }
}
