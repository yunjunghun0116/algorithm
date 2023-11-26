public class bible1 {
    public int solution(String my_string) {
        int answer = 0;
        String removeAlphabetStr = my_string.replaceAll("[a-zA-Z]+"," ").trim();
        String[] numberList = removeAlphabetStr.split(" ");
        for(String num : numberList){
            try{
                answer+=Integer.parseInt(num);
            }catch (Exception e){
                answer+=0;
            }

        }
        return answer;
    }
}
