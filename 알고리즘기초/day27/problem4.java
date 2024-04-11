import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870 연속된 부분 수열의 합
// 64.7점 시간초과나옴 -> 이중포문을 쓰면 안될것같음. DP로 어떻게 접근할지 고민해봐야할듯

public class problem4 {
    public int[] solution(int[] sequence, int k) {
        int[] sumArr = new int[sequence.length];
        int index = 0;
        for (int num : sequence) {
            sumArr[index] = num;
            if (index > 0) {
                sumArr[index] += sumArr[index - 1];
            }
            index++;
        }


        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[sequence.length + 1];
        for (int i = 0; i < sumArr.length; i++) {
            if (i > 0 && sumArr[i] - sumArr[i - 1] > k) {
                break;
            }
            if (sumArr[i] < k) continue;
            if (sumArr[i] == k) {
                minLength = i + 1;
                answer = new int[]{0, i};
            }
            for (int j = i - 1; j >= 0; j--) {
                if (sumArr[i] - sumArr[j] > k) break;
                if (i - j > minLength) break;
                if (sumArr[i] - sumArr[j] == k) {
                    if (i - j < minLength) {
                        minLength = i - j;
                        answer = new int[]{j + 1, i};
                        continue;
                    }
                    if (i - j == minLength) {
                        if (j < answer[0]) {
                            answer = new int[]{j + 1, i};
                        }
                    }

                }
            }
        }


        return answer;
    }
}
