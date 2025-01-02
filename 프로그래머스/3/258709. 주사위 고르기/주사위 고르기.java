import java.util.*;

class Solution {
    
    static List<String> rList = new ArrayList<>();

    public static int[] solution(int[][] dice) {
        // 6^5 짜리 A배열, B배열 만들기 -> 하나가 정해지면 나머지도 알아서 정해지니까
        // 그때 나올수 있는 모든 경우의수를 가져와서 작업하기
        // 그러면 연산 : 이기는 경우의 수만 모두 가져와서 그걸 지정해주기


        Map<String, Integer> resultCountMap = new HashMap<>();

        getCombinationResult("", -1, dice.length);
        // 결과는 0~5 가 아니라 1~6 이므로 각각 +1 해주기

        for (String str : rList) {
            //10C5 = 252 번의 연산 - 각각 14000
            if(resultCountMap.containsKey(str)) continue;
            // str : 13457 처럼 고르는 갯수
            // bStr : 02689
            // 1에서 6개 3에서 6개 ...
            Queue<Integer> aSumQueue = new LinkedList();

            Queue<Integer> bSumQueue = new LinkedList();

            String bStr ="";
            for (int i = 0; i < dice.length; i++) {
                if (str.contains(String.valueOf(i))) continue;
                bStr = bStr + i;
            }

            int maxSize = dice.length / 2;
            int curAIndex = 0;
            int curBIndex = 0;
            aSumQueue.add(0);
            bSumQueue.add(0);
            //6^5

            while (curAIndex < maxSize) {
                String curr = String.valueOf(str.charAt(curAIndex));
                int diceNum = Integer.parseInt(curr);
                int[] dices = dice[diceNum];
                int size = aSumQueue.size();
                for (int i = 0; i < size; i++) {
                    int result = aSumQueue.poll();
                    for (int j = 0; j < 6; j++) {
                        aSumQueue.add(result + dices[j]);
                    }
                }
                curAIndex++;
            }

            //6^5
            while (curBIndex < maxSize) {
                String curr = String.valueOf(bStr.charAt(curBIndex));
                int diceNum = Integer.parseInt(curr);
                int[] dices = dice[diceNum];
                int size = bSumQueue.size();
                for (int i = 0; i < size; i++) {
                    int result = bSumQueue.poll();
                    for (int j = 0; j < 6; j++) {
                        bSumQueue.add(result + dices[j]);
                    }
                }
                curBIndex++;
            }

            int winACount = 0;

            /* 여기서 최단 탐색 */

            List<Integer> aSumList = new ArrayList<>();
            aSumList.addAll(aSumQueue);
            Collections.sort(aSumList);

            List<Integer> bSumList = new ArrayList<>();
            bSumList.addAll(bSumQueue);
            Collections.sort(bSumList);

            int count = 0;
            for (int aSum : aSumList) {
                count+=findCount(aSum,bSumList);
            }

            resultCountMap.put(str, count);
        }


        int maxCount = Integer.MIN_VALUE;
        String maxString = "";
        for (Map.Entry<String, Integer> entry : resultCountMap.entrySet()) {
            //10C5 = 252
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxString = entry.getKey();
            }
        }

        int[] result = new int[maxString.length()];
        for (int i = 0; i < maxString.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(maxString.charAt(i))) + 1;
        }

        return result;
    }

    public static void getCombinationResult(String currentString, int currentNumber, int size) {
        if (currentString.length() == size/2) {
            rList.add(currentString);
            return;
        }
        for (int i = currentNumber + 1; i < size; i++) {
            String nextStr = currentString + i;
            getCombinationResult(nextStr , i, size);
        }
    }

    public static int findCount(int value,List<Integer> valueList){
        //이분탐색

        int start = 0;
        int end = valueList.size()-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(valueList.get(mid)==value){
                int index = mid;
                while(index>=0){
                    if(valueList.get(index)<value){
                        return index+1;
                    }
                    index--;
                }
                return index+1;
            }
            if(valueList.get(mid)>value){
                end = mid-1;
                continue;
            }
            start = mid+1;
        }
        return end+1;
    }

    
}