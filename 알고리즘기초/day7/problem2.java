public class problem2 {
    public int[] solution(int l, int r) {
        int[] answer = new int[100];
        int currentIndex = 0;
        for(int i = l; i <= r ; i++){
            String str = String.valueOf(i).replace("0","").replace("5","");
            if(str.length() == 0){
                answer[currentIndex++] = i;
            }
        }

        int[] result = new int[currentIndex];
        System.arraycopy(answer,0,result,0,currentIndex);
        if(result.length == 0){
            int[] emptyArray = {-1};
            return emptyArray;
        }
        return result;
    }
}
