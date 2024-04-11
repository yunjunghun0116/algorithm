public class problem1 {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i]>= 50 && arr[i]%2==0 ){
                answer[i] = arr[i]/2;
                continue;
            }
            if(arr[i]<50 && arr[i]%2==1){
                answer[i] = arr[i]*2;
                continue;
            }
            answer[i] = arr[i];
        }
        return answer;
    }
}
