public class bible4 {
    public int solution(int i, int j, int k) {
        int counts = 0;
        for(int start = i; start <= j; start++){
            String basedString = String.valueOf(start);
            String replacedString = String.valueOf(start).replaceAll(String.valueOf(k), "");
            if(basedString.length()!= replacedString.length()){
                counts+=basedString.length()- replacedString.length();
            }
        }
        return counts;
    }
}
