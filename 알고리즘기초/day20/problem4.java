public class problem4 {
    public int[] solution(int[] arr, int n) {
        int[] result = arr;
        if(arr.length%2==0){
            for(int i = 0; i < result.length; i++){
                if(i%2==1){
                    result[i]+=n;
                }
            }
            return result;
        }
        for(int i = 0; i < result.length; i++){
            if(i%2==0){
                result[i]+=n;
            }
        }
        return result;
    }
}
