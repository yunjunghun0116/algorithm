import java.util.*;

public class permutationAndCombination {

    static List<String> result =  new ArrayList<>();
    static List<String> comResult =  new ArrayList<>();

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5};
        String strings = "ABCDE";
        boolean[] visited = new boolean[numbers.length];
        permutation("",visited,numbers,3);
        //combination("",-1,2,numbers);
        strCombination("",-1,2,strings);
        for(String str : comResult){
            System.out.println(str);
        }
    }

    public static void permutation(String preStr,boolean[] visited,int[] numbers,int length){
        //선택한 수를 맨앞에 배치해가면서 계속 수를 더해가는 모든 과정 ( 순열 )
        if(preStr.length() == length){
            result.add(preStr);
            return;
        }
        for(int i = 0; i < numbers.length; i++ ){
            if(visited[i]) continue;
            visited[i] = true;
            permutation(preStr+numbers[i],visited,numbers,length);
            visited[i] = false;
        }
    }

    public static void combination(String preStr,int lastNumber,int length,int[] numbers){
        // 오히려 조합은 오름차순으로 정렬된것이라고 생각하면 접근이 쉽다.
        if(preStr.length() == length){
            comResult.add(preStr);
            return;
        }
        for(int i = lastNumber+1; i < numbers.length; i++ ){
            combination(preStr+numbers[i],i,length,numbers);
        }
    }

    public static void strCombination(String preStr,int lastNumber,int length,String str){
        // 오히려 조합은 오름차순으로 정렬된것이라고 생각하면 접근이 쉽다.
        if(preStr.length() == length){
            comResult.add(preStr);
            return;
        }
        for(int i = lastNumber+1; i < str.length(); i++ ){
            strCombination(preStr+str.charAt(i),i,length,str);
        }
    }
}
