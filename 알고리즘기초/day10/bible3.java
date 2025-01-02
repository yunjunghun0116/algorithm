public class bible3 {
    public int solution(int[] numbers, int k) {
        int n = 2 * k - 1;
        int[] arr = new int[numbers.length * 2];
        System.arraycopy(numbers, 0, arr, 0, numbers.length);
        System.arraycopy(numbers, 0, arr, numbers.length, numbers.length);
        if (n % numbers.length == 0) {
            return arr[arr.length - 1];
        }
        return arr[n % (numbers.length) - 1];
    }
}
