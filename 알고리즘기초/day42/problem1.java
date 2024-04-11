import java.util.*;

public class problem1 {
    static int minStress = Integer.MAX_VALUE;
    static int maxSize = 0;
    static boolean remainMineral = false;
    static Map<String, Map<String, Integer>> costMap = new HashMap<>();
    static String[] pickNameArray = new String[]{"diamond", "iron", "stone"};

    public static void main(String[] args) {
        int result = solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        System.out.println(result);
    }

    public static int solution(int[] picks, String[] minerals) {


        Map<String, Integer> costDiamondMap = new HashMap<>();
        Map<String, Integer> costIronMap = new HashMap<>();
        Map<String, Integer> costStoneMap = new HashMap<>();
        costDiamondMap.put("diamond", 1);
        costDiamondMap.put("iron", 1);
        costDiamondMap.put("stone", 1);
        costIronMap.put("diamond", 5);
        costIronMap.put("iron", 1);
        costIronMap.put("stone", 1);
        costStoneMap.put("diamond", 25);
        costStoneMap.put("iron", 5);
        costStoneMap.put("stone", 1);
        costMap.put("diamond", costDiamondMap);
        costMap.put("iron", costIronMap);
        costMap.put("stone", costStoneMap);

        remainMineral = minerals.length % 5 != 0;
        maxSize = minerals.length / 5;


        findMineral(minerals, 0, picks, 0);
        return minStress;
    }

    public static void findMineral(String[] remainMinerals, int currentCount, int[] remainPicks, int currentStress) {
        boolean noPicks = true;
        for (int i = 0; i < 3; i++) {
            if (remainPicks[i] != 0){
                noPicks = false;
                break;
            }
        }
        if (noPicks) {
            minStress = Math.min(minStress, currentStress);
            return;
        }
        if (currentCount == maxSize) {
            // 여기서 최댓값 비교 -> picks를 다썼으면 끝, mineral 남아있으면 처리해주기
            if (remainMineral) {
                String remainPick = "";
                if (remainPicks[2] > 0) remainPick = "stone";
                if (remainPicks[1] > 0) remainPick = "iron";
                if (remainPicks[0] > 0) remainPick = "diamond";
                Map<String, Integer> costPickMap = costMap.get(remainPick);
                for (int i = 0; i < remainMinerals.length; i++) {
                    currentStress += costPickMap.get(remainMinerals[i]);
                }
                minStress = Math.min(minStress, currentStress);
                return;
            }
            minStress = Math.min(minStress, currentStress);
            return;
        }
        String[] newRemainMinerals = new String[remainMinerals.length - 5];
        System.arraycopy(remainMinerals, 5, newRemainMinerals, 0, newRemainMinerals.length);
        for (int i = 0; i < 3; i++) {
            if (remainPicks[i] == 0) continue;
            String pickName = pickNameArray[i];
            int newStress = currentStress;
            Map<String, Integer> costPickMap = costMap.get(pickName);
            remainPicks[i]--;
            for (int j = 0; j < 5; j++) {
                newStress += costPickMap.get(remainMinerals[j]);
            }
            findMineral(newRemainMinerals, currentCount + 1, remainPicks, newStress);
            remainPicks[i]++;
        }
    }
}
