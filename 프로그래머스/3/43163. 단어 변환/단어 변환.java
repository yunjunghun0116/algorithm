import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Object[]> positionQueue = new LinkedList<>();
        Map<String, Integer> minCountMap = new HashMap<>();

        positionQueue.add(new Object[]{begin, 0});
        minCountMap.put(begin, 0);

        while (!positionQueue.isEmpty()) {
            Object[] pollData = positionQueue.poll();
            String preWord = (String) pollData[0];
            int count = (int) pollData[1];
            if(preWord.equals(target)) return count;
            for (String word : words) {
                if (canChange(preWord, word)) {
                    if (minCountMap.containsKey(word)) {
                        int wordCount = minCountMap.get(word);
                        if (wordCount < count + 1) continue;
                    }
                    positionQueue.add(new Object[]{word, count + 1});
                    minCountMap.put(word, count + 1);
                }
            }
        }

        return answer;
    }
    
    public boolean canChange(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) continue;
            count++;
        }
        return count == 1;
    }
}