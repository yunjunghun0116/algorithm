import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static int[] numbers;
    public static int N;

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine()) - 1;
        }
    }
    // 1 -> 3 -> 1, 5 -> 5 => 사이클 모두 합치면 되는건가?
    // 사이클을 찾아야 되는데 how?
    // 1부터 N까지 전부 사이클 최대한 찾아보는데
    // 시작 I를 갖고 해야하는구나, End 가 I면 끝이다. => 해당 visited[true]인 곳을 전부 add해주면 된다.
    public static void solve(){
        Set<Integer> result = new HashSet<>();

        for(int start = 0; start < N; start++){
            boolean[] visited = new boolean[N];
            Stack<Integer> idxStack = new Stack<>();
            idxStack.push(start);

            while(!idxStack.isEmpty()){
                int idx = idxStack.pop();
                if(visited[idx]){
                    if(idx == start){
                        for(int i = 0; i < N; i++){
                            if(visited[i]){
                                result.add(i);
                            }
                        }
                    }
                    break;
                }
                visited[idx] = true;
                idxStack.push(numbers[idx]);
            }
        }

        List<Integer> list = result.stream().collect(Collectors.toList());
       list.sort ((a,b)->a-b);

        System.out.println(list.size());
        for(int num : list){
            System.out.println(num+1);
        }
    }
}
