import java.util.*;

public class problem3 {

    public static void main(String[] args) {
        int[] result = solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println("result[0] = " + result[0] + ", result[1] = " + result[1]);
    }

    public static int[] solution(int n, String[] words) {
        int cycle = 1;
        String[] currentWordArr = new String[n];
        int index = 0;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (index == n) {
                cycle++;
                index = 0;
            }
            String preWord = index == 0 ? currentWordArr[n - 1] : currentWordArr[index - 1];
            boolean isWrongWord = (preWord != null && !String.valueOf(preWord.charAt(preWord.length() - 1)).equals(String.valueOf(word.charAt(0))));
            if (wordMap.containsKey(word) || isWrongWord) {
                int[] result = new int[2];
                result[0] = index + 1;
                result[1] = cycle;
                return result;
            }

            currentWordArr[index++] = word;
            wordMap.put(word, 0);
        }

        return new int[]{0, 0};
    }
}
