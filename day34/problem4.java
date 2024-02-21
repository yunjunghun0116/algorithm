import java.util.*;

public class problem4 {

    public int[] solution(String[] operations) {

        TreeSet<Integer> tree = new TreeSet();
        for(String operation : operations){
            String[] s = operation.split(" ");
            if(s[0].equals("I")){
                tree.add(Integer.parseInt(s[1]));
                continue;
            }
            if(s[0].equals("D")){
                if(tree.isEmpty()) continue;
                if(s[1].equals("1")){
                    tree.pollLast();
                    continue;
                }
                tree.pollFirst();
            }
        }

        if(tree.isEmpty()) return new int[]{0,0};
        int minValue = tree.first();
        int maxValue = tree.last();
        return new int[] {maxValue,minValue};
    }

}
