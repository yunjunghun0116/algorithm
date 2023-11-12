import java.util.Arrays;

public class bible4 {
    public int solution(int[] sides) {
        boolean canMake = false;
        Arrays.sort(sides);
        canMake = sides[2] <sides[0]+sides[1];
        return canMake?1:2;
    }
}
