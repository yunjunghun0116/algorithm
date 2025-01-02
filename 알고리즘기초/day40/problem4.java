import java.util.*;

public class problem4 {


    public static void main(String[] args) {
        long result = solution(10,new int[]{6,8,10});
        System.out.println(result);
        System.out.println();

        long result2 = solution(4,new int[]{1,1,1});
        System.out.println(result2);
        System.out.println();
    }
    public static long solution(int n, int[] times) {
        long minValue = Integer.MAX_VALUE;
        for (int i : times) {
            minValue = Math.min(minValue, i);
        }
        long start = 0;
        long end = minValue * n; // time

        while(start<=end){
            long mid = (start+end)/2;

            long count = 0;
            for(int i = 0; i < times.length; i++){
                count+=(mid/times[i]);
            }

            System.out.println("start : "+start+", end : "+end+", mid : " + mid + ", count : "+count);

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

        // start == mid

        return (start+end)/2+1;
    }
}
