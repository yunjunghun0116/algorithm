public class problem5 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        System.arraycopy(arr,0,answer,0,arr.length);
        for(int[] query : queries){
            for(int i = query[0]; i <= query[1]; i++){
                answer[i] = answer[i]+1;
            }
        }
        return answer;
    }
}
