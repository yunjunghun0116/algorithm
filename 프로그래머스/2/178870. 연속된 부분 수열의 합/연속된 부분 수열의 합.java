import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
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

    
        return new int[]{answerList.get(0)[0], answerList.get(0)[1]};
    }
}