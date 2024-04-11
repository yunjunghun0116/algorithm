public class problem5 {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;
        for(int i = 0; i < query.length; i++){
            if(i%2==0){
                answer = evenFunction(answer,query[i]);
                continue;
            }
            answer = oddFunction(answer,query[i]);
        }
        return answer;
    }
    public int[] oddFunction(int[] arr,int idx){
        int[] result = new int[arr.length-idx];
        System.arraycopy(arr,idx,result,0,result.length);
        return result;
    }
    public int[] evenFunction(int[] arr,int idx){
        int[] result = new int[idx+1];
        System.arraycopy(arr,0,result,0,result.length);
        return result;
    }
}
