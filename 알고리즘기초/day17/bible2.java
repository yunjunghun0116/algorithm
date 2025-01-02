import java.util.ArrayList;

public class bible2 {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> arrList = new ArrayList();
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                arrList.add(numlist[i]);
            }
        }

        return arrList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
