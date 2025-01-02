import java.util.*;

public class Main{
    static List<Integer> arr = new ArrayList<>();
    static boolean[] used = new boolean[9];
    static int n;
    static int m;

    static void input(){
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
    }

    static void solution(){
        if(arr.size()==m){
            print();
            return;
        }
        for(int i = 1; i <= n; i++){
            if(used[i]) continue;
            arr.add(i);
            used[i] = true;
            solution();
            arr.remove(arr.size()-1);
            used[i] = false;
        }
    }

    static void print(){
        for(int i = 0; i < m; i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
