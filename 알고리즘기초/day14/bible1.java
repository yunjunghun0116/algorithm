import java.util.Arrays;

public class bible1 {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= n) {
                if (n - array[i - 1] <= array[i] - n) {
                    return array[i - 1];
                }
                return array[i];
            }
        }
        return array[array.length - 1];
    }
}
