public class problem2 {
    public int solution(int[] arr) {
        int count = 0;
        int[] arr1 = arr;
        int[] arr2 = func(arr);
        while(!checkSameArray(arr1,arr2)){
            arr1 = arr2;
            arr2 = func(arr2);
            count++;
        }
        return count;
    }

    public int[] func(int[] arr){
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i]>= 50 && arr[i]%2==0 ){
                answer[i] = arr[i]/2;
                continue;
            }
            if(arr[i]<50 && arr[i]%2==1){
                answer[i] = arr[i]*2+1;
                continue;
            }
            answer[i] = arr[i];
        }
        return answer;
    }

    public boolean checkSameArray(int[] arr1,int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
