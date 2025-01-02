public class problem4 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        System.arraycopy(arr,0,answer,0,arr.length);
        for(int[] query:queries){
            int temp = answer[query[0]];
            answer[query[0]] = answer[query[1]];
            answer[query[1]] = temp;
        }
        return answer;
    }
}
