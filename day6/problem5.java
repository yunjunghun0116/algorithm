public class problem5 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {

            int startIndex = query[0];
            int endIndex = query[1];
            int minimumValue = query[2];
            boolean flag = false;
            int TempValue = 1000001;
            for (int i = startIndex; i <= endIndex; i++) {
                if (arr[i] > minimumValue && arr[i] < TempValue) {
                    TempValue = arr[i];
                    flag = true;
                }
            }
            if (flag) {
                answer[index++] = TempValue;
                continue;
            }
            answer[index++] = -1;

        }
        return answer;
    }
}
