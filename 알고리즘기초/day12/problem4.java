public class problem4 {
    public int[] solution(int[] arr) {

        int startIdx = -1;
        int endIdx = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                if(startIdx <0){
                    startIdx = i;
                    continue;
                }
                endIdx = i;
            }
        }

        if(endIdx == -1){
            if(startIdx == -1){
                int[] result = {-1};
                return result;
            }
            int[] result = {2};
            return result;
        }
        int[] result = new int[endIdx-startIdx+1];

        System.arraycopy(arr,startIdx,result,0,result.length);
        return result;
    }
}
