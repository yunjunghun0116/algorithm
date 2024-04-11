public class problem4 {
    public int solution(int[] num_list) {
        int sum = 0;
        int multiple = 1;
        for (int number : num_list) {
            sum += number;
            multiple *= number;
        }
        return multiple < Math.pow(sum, 2) ? 1 : 0;
    }
}
