public class bible4 {
    public int solution(int[] common) {
        boolean isAdd = true;
        for (int i = 0; i < common.length - 2; i++) {
            if (common[i + 2] - common[i + 1] == common[i + 1] - common[i])
                continue;
            isAdd = false;
        }
        if (isAdd) {
            return common[common.length - 1] + common[1] - common[0];
        }
        return return common[common.length - 1] * (common[1] / common[0]);
    }
}
