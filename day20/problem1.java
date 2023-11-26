public class problem1 {
    public static int[] solution(int[] arr) {
        int i = 0;
        while(Math.pow(2,i)<arr.length){
            i++;
        }
        int[] result = new int[(int)Math.pow(2,i)];
        System.arraycopy(arr,0,result,0,arr.length);
        for(int index = arr.length; index < result.length; index++){
            result[index] = 0;
        }
        return result;
    }
}
