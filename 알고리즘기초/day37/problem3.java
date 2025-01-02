import java.util.*;

public class problem3 {
    static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {

        int[] result = solution(new int[][]{{40, 10000},{25, 10000}},new int[]{7000, 9000});
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        permutationStr("",emoticons.length);
        int[][] priceBoard = new int[emoticons.length][5];


        for(int i = 0; i < emoticons.length; i++ ){
            for(int j = 0; j < 5; j++){
                priceBoard[i][j] = emoticons[i]*(10-j)/10;
            }
        }

        int[] answer = new int[2];
        // maxUserCount, maxPrice
        for(String resultStr : resultList){
            int countUser = 0;
            int countPrice = 0;
            for(int[] user : users){
                int price = 0;
                for(int i = 0; i < emoticons.length; i++){
                    int index = Integer.parseInt(String.valueOf(resultStr.charAt(i)));
                    if(user[0] <= 10*index){
                        price += priceBoard[i][index];
                    }
                }
                if(price>=user[1]){
                    countUser++;
                    continue;
                }
                countPrice+=price;
            }

            if(answer[0] < countUser){
                answer[0] = countUser;
                answer[1] = countPrice;
                continue;
            }
            if(answer[0] == countUser){
                if(answer[1] < countPrice){
                    answer[1] = countPrice;
                }
            }
        }
        return answer;
    }

    public static void permutationStr(String currentString, int size) {
        if (currentString.length() == size) {
            resultList.add(currentString);
            return;
        }
        for (int i = 0; i < 5; i++) {
            permutationStr(currentString + i, size);
        }
    }
}
