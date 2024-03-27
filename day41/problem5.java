import java.util.*;

public class problem5 {
    // n+1 카드게임 - 이후 다시 풀어보기 왜 틀렸는지 예외케이스 모르겠음
    public static void main(String[] args) {
        solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4});
        //solution(0, new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7});
        //solution(0, new int[]{1, 12, 2, 11, 3, 10, 4, 9, 5, 8, 6, 7});
    }


    public static int solution(int coin, int[] cards) {

        // 배열에서 가지고있는건 0 - n/3까지 갖고있고
        // 그 이후에있는것들중 0~coin 개를 찾아 합쳐 최대 n+1이 되는 경우의 수
        // 즉 n
        int freeOverIndex = cards.length / 3;
        int result = cards.length + 1;
        Map<Integer, Integer> numberIndexMap = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            numberIndexMap.put(cards[i], i);
        }
        int round = 1;
        while (true) {
            boolean[] find = new boolean[1001];
            int count = 0;
            int maxIndex = freeOverIndex + round * 2;
            int overCount = 0;
            if (maxIndex > cards.length) break;
            for (int i = 0; i < maxIndex; i++) {
                int cardValue = cards[i];
                int subValue = result - cardValue;
                if (find[cardValue] || find[subValue] || numberIndexMap.get(subValue) >= maxIndex) {
                    continue;
                }
                int preOverCount = overCount;
                if (i >= freeOverIndex) preOverCount++;
                if (numberIndexMap.get(subValue) >= freeOverIndex) preOverCount++;
                if(preOverCount>coin){
                    continue;
                }
                overCount = preOverCount;
                find[cardValue] = true;
                find[subValue] = true;
                count++;

            }
            if (count < round) break;
            round++;
        }
        return round;
    }
}


// System.out.println("round : "+answer + ", cardValue : "+cardValue+", subValue : " +subValue+", count : "+count);
// System.out.println("result : "+answer);