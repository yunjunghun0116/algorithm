public class problem1 {
    public int solution(int[][] arr) {
        int answer = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == arr[j][i]) continue;
                return 0;
            }
        }
        return answer;
    }
}
