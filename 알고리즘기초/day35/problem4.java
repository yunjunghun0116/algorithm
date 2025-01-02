public class problem4 {

    public static void main(String[] args) {
        System.out.println(solution(" a   b"));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        boolean findWord = false;
        int index = 0;
        while(answer.length() < s.length()){
            if(String.valueOf(s.charAt(index)).equals(" ")){
                if(findWord){
                    findWord = false;
                }
                answer.append(s.charAt(index++));
                continue;
            }
            if(findWord){
                answer.append(String.valueOf(s.charAt(index++)).toLowerCase());
                continue;
            }
            answer.append(String.valueOf(s.charAt(index++)).toUpperCase());
            findWord = true;
        }
        return answer.toString();

    }
}
