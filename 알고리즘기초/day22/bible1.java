public class bible1 {
    public int solution(int n) {
        int count = 1;
        for (int i = 1; i < 300; i++) {
            if (i % 3 == 0) {
                continue;
            }
            if (String.valueOf(i).contains("3")) {
                continue;
            }
            if (count == n) {
                return i;
            }
            count++;
        }
        return 0;
    }
}
