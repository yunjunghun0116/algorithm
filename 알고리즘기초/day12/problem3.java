public class problem3 {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] intervalA = intervals[0];
        int[] intervalB = intervals[1];
        int[] arrA = new int[intervalA[1]-intervalA[0]+1];
        int[] arrB = new int[intervalB[1]-intervalB[0]+1];
        int[] result = new int[arrA.length + arrB.length];

        System.arraycopy(arr,intervalA[0],arrA,0,arrA.length);
        System.arraycopy(arr,intervalB[0],arrB,0,arrB.length);
        System.arraycopy(arrA,0,result,0,arrA.length);
        System.arraycopy(arrB,0,result,arrA.length,arrB.length);

        return result;
    }
}
