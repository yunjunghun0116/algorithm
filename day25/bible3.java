public class bible3 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(num%2==1){
            int startNumber = total/num-(num-1)/2;
            for(int i = 0;i < num; i++ ){
                answer[i] = startNumber++;
            }
            return answer;
        }
        int midSum = total/(num/2);
        int leftNum = (midSum-1)/2;
        int startNumber = leftNum - (num-2)/2;
        for(int i = 0;i < num; i++ ){
            answer[i] = startNumber++;
        }
        return answer;
    }
}
