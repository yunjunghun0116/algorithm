class Solution {
    public long solution(int n, int[] times) {
        long minValue = Integer.MAX_VALUE;
        for (int i : times) {
            minValue = Math.min(minValue, i);
        }
        long start = 0;
        long end = minValue * n+1; // time

        long minTime = Long.MAX_VALUE;

        while(start<=end){
            long mid = (start+end)/2;
            long count = 0;
            for(int i = 0; i < times.length; i++){
                count+=(mid/times[i]);
            }
            if(count == n){
                while(count==n){
                    count = 0;
                    mid --;
                    for(int i = 0; i < times.length; i++){
                        count+=(mid/times[i]);
                    }
                }
                return mid+1;
            }
            if(count>n){
                end = mid-1;
                continue;
            }
            start = mid+1;

        }

        
        return (start+end)/2+1;
    }
}