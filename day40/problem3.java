import java.util.*;

public class problem3 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    static class LongObject implements Comparable<LongObject> {
        Long currentSum;
        int index;

        public LongObject(Long currentSum, int index) {
            this.currentSum = currentSum;
            this.index = index;
        }

        @Override
        public int compareTo(LongObject object) {
            return this.currentSum <= object.currentSum ? -1 : 1;
        }
    }

    public static long solution(int n, int[] times) {
        PriorityQueue<LongObject> nextTime = new PriorityQueue<>();
        // 28 30
        int[] checkTable = new int[times.length];
        for (int i = 0; i < times.length; i++) {
            checkTable[i] = times[i];
            nextTime.add(new LongObject(Long.parseLong(String.valueOf(times[i])), i));
        }

        for (int i = 0; i < n-1; i++) {
            LongObject longObject = nextTime.poll();
            nextTime.add(new LongObject(longObject.currentSum + Long.parseLong(String.valueOf(times[longObject.index])), longObject.index));
        }

        LongObject longObject = nextTime.poll();

        return longObject.currentSum ;
    }
}
