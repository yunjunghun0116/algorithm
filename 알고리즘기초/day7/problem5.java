public class problem5 {
    public int[] solution(int[] arr) {
        int[] stk = {};
        for (int i = 0; i < arr.length; i++) {
            if (stk.length == 0) {
                stk = add(stk, arr[i]);
                continue;
            }
            if (stk[stk.length - 1] < arr[i]) {
                stk = add(stk, arr[i]);
                continue;
            }
            stk = pop(stk);
            i--;
        }

        return stk;
    }

    public int[] add(int[] arr, int value) {
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, arr.length);
        result[arr.length] = value;
        return result;
    }

    public int[] pop(int[] arr) {
        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, arr.length - 1);
        return result;
    }
}
