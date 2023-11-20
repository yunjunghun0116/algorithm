import java.util.ArrayList;

public class problem3 {
    public String[] solution(String[] strArr) {
        ArrayList<String> arrList = new ArrayList();
        for(int i = 0; i < strArr.length; i++){
           String subStr = strArr[i].replaceAll("(ad)","");
           if(subStr.length()==strArr[i].length()){
               arrList.add(strArr[i]);
           }
        }
        String[] result = arrList.toArray(String[]::new);
        return result;
    }
}
