public class problem2 {
    public int solution(int[] rank, boolean[] attendance) {
        int[] result = new int[3];
        int index = 0;
        for(int i = 1; i <= rank.length; i++){
            if(index == 3) break;
            for(int j = 0; j < rank.length ; j++){
                if(i == rank[j]){
                    if(attendance[j]){
                        result[index++] = j;
                    }
                    break;
                }
            }
        }


        return 10000*result[0] + 100*result[1]+result[2];
    }
}
