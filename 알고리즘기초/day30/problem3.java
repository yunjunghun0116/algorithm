import java.util.*;

public class problem3 {

    public static void main(String[] args) {
        int count = solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(count);
    }

    public static int solution(String begin, String target, String[] words) {
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

        return 0;
    }

    public static boolean canChange(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) continue;
            count++;
        }
        return count == 1;
    }
}
