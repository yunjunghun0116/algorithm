import java.util.*;

public class problem1 {

    public static void main(String[] args) {
        int result1 = solution(new int[]{5, 1, 9, 2, 6, 3}, 1);
//        int result2 = solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(result1);
//        System.out.println(result2);
    }

    public static int solution(int[] priorities, int location) {
//      priorities 의 location 인덱스에 위치한 값은 몇번째로 추출이 되는지를 구하는 문제
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparing((point) -> -point));
        for (int priority : priorities) {
            priorityQueue.offer(priority);
        }
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == priorityQueue.peek()) {
                    priorityQueue.poll();
                    count++;
                    if(i == location){
                        return count;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}
