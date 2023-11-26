import java.util.*;

public class bible2 {
    public String[] solution(String my_str, int n) {
        List<String> stringList = new ArrayList<>();
        String subStr = my_str;
        while(subStr.length()>n){
            stringList.add(subStr.substring(0,n));
            subStr = subStr.substring(n);
        }
        stringList.add(subStr);
        return stringList.stream().toArray(String[]::new);
    }
}
