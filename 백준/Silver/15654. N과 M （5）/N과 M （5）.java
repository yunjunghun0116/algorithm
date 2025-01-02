import java.util.*;

public class Main{
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> numbers = new ArrayList<>();
    static boolean[] usedIndexes = new boolean[10];
    static int n;
    static int m;

    static void input(){
        var sc = new Scanner(System.in);
        var inputs = sc.nextLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        var numberInputs = sc.nextLine().split(" ");
        for(var number: numberInputs){
            numbers.add(Integer.parseInt(number));
        }

        numbers.sort((a,b)->a-b);
    }

    static void solution(){
        if(arr.size()==m){
            print();
            return;
        }
        for(int i = 0; i < n; i++){
            if(usedIndexes[i]) continue;
            arr.add(numbers.get(i));
            usedIndexes[i] = true;
            solution();
            arr.remove(arr.size()-1);
            usedIndexes[i] = false;
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
