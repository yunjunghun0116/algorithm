import java.util.*;

public class problem2 {

    public static void main(String[] args) {
        solution(2);
    }

    static List<int[]> tempList = new ArrayList<>();

    public static int[][] solution(int n) {
        hanoi(1,3,2,2);

        return tempList.toArray(int[][]::new);
    }

    public static void hanoi(int start,int end,int mid,int size){
        if(size==1){
            tempList.add(new int[]{start,end});
            return;
        }
        hanoi(start,mid,end,size-1);
        tempList.add(new int[]{start,end});
        hanoi(mid,end,start,size-1);
    }
}
