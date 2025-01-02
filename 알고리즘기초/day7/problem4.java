public class problem4 {
    public int[] solution(int n) {
        int[] subArr = new int[20];

        int index = 0;
        int subNumber = n;
        subArr[index++] = subNumber;
        while(subNumber !=1){
            if(subNumber%2==1){
                subNumber = subNumber*3 +1;
                subArr[index++] = subNumber;
                continue;
            }
            subNumber = subNumber/2;
            subArr[index++] = subNumber;
        }

        int size = 0;
        for(int i = 0; i < subArr.length; i++){
            if(subArr[i] == 1){
                size = i;
                break;
            }
        }

        int[] result = new int[size+1];
        System.arraycopy(subArr,0,result,0,result.length);
        return result;
    }
}
