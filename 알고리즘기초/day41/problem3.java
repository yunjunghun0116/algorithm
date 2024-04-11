public class problem3 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int value = k;
        int count = 0;
        while(value>1){
            count++;
            if(value%2==0){
                value = value/2;
                continue;
            }
            value = value*3+1;
        }
        int[] graphValues = new int[count+1];
        int index = 0;
        while(k>1){
            graphValues[index++] = k;
            if(k%2==0){
                k = k/2;
                continue;
            }
            k = k*3+1;
        }
        graphValues[index] = 1;
        for(int i = 0; i < ranges.length;i++){
            int[] range = ranges[i];
            int start = range[0];
            int end = count+range[1];
            if(start>end){
                answer[i] = -1 * 1.0;
                continue;
            }
            double result = 0;
            for(int j = start; j < end; j++){
                result+=(graphValues[j]+graphValues[j+1])/2.0;
            }
            answer[i] =result*1.0;
        }

        return answer;
    }
}
