import java.util.ArrayList;

public class problem2 {
    public String[] solution(String myString) {
        ArrayList<String> strList = new ArrayList<>();
        String[] splitList = myString.split("x");
        for(String s : splitList){
            if(s.length()>0){
                strList.add(s);
            }
        }


        return strList.stream().sorted().toArray(String[]::new);
    }
}
