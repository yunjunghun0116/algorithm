import java.util.*;

// Stack 으로 해결하려고 했는데 시간초과 및 왜 틀리는지 모르겠음 -> 1. 잘못된 점 찾고 2. 시간 효율성 개선하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12979
public class problem4 {

    public static void main(String[] args) {
        int result = solution(16, new int[]{9}, 2);
        System.out.println(result);
    }

    public static int solution(int n, int[] stations, int w) {
        Stack<int[]> positionStack = new Stack<>();
        for(int station : stations){
            int start = Math.max(0,station-1-w);
            int end = Math.min(station-1+w,n-1);
            if(positionStack.isEmpty()){
                positionStack.push(new int[]{start,end});
                continue;
            }
            int[] position = positionStack.peek();
            if(start <= position[1] ){
                positionStack.pop();
                positionStack.push(new int[]{position[0],end});
                continue;
            }
            positionStack.push(new int[]{start,end});
        }

        int start = 0;
        List<int[]> positionList = new ArrayList<>(positionStack);
        List<Integer> sizeList = new ArrayList<>();
        for(int[] position : positionList){
            if(start < position[0]){
                int size = position[0]-start;
                sizeList.add(size);
                start = position[1]+1;
            }
        }

        if(start < n-1){
            int size = n-start;
            sizeList.add(size);
        }

        int answer = 0;
        for (int size : sizeList) {
            int divider = w * 2 + 1;
            if (size % divider == 0) {
                answer += size / divider;
                continue;
            }
            answer += size / divider;
            answer += 1;
        }

        return answer;

    }
}
