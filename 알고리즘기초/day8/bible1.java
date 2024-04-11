public class bible1 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] result = new int[num2 - num1 + 1];
        System.arraycopy(numbers, num1, result, 0, result.length);
        return result;
    }
}
