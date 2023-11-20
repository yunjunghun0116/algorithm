import java.util.ArrayList;

public class problem1 {
    public int[] solution(String myString) {

        String[] splitArr = myString.split("x");
        ArrayList<Integer> arrList = new ArrayList();
        for(String s : splitArr){
            arrList.add(s.length());
        }
        if(myString.endsWith("x")){
            arrList.add(0);
        }
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}
