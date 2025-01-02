public class bible4 {
    public int solution(String[] spell, String[] dic) {
        boolean answer = false;
        for(String str : dic){
            String replaceStr = str;
            for(String alpha : spell){
                replaceStr = replaceStr.replaceFirst(alpha,"7");
            }
            int count = 0;
            for(int i = 0; i < str.length() ;i++){
                if(String.valueOf(replaceStr.charAt(i)).equals("7")){
                    count++;
                }
            }
            if(count == spell.length){
                answer = true;
            }
        }
        return answer?1:2;
    }
}
