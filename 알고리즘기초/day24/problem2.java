import java.util.*;

public class problem2 {
    public String[] solution(String[] picture, int k) {
        List<String> newPicture = new ArrayList<>();
        for (String pic : picture) {
            String newPic = "";
            for (int i = 0; i < pic.length(); i++) {
                for (int j = 0; j < k; j++) {
                    newPic += pic.charAt(i) ;
                }
            }
            for (int i = 0; i < k; i++) {
                newPicture.add(newPic);
            }
        }
        return newPicture.toArray(String[]::new);
    }
}
