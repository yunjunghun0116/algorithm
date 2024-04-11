public class problem2 {
    public  int[][] solution(int[][] arr) {
        int maxSize = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[maxSize][maxSize];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i],0,answer[i],0,arr[i].length);
        }
        return answer;
    }
}
