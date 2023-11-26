import java.io.IOException;

public class bible4 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("x"));
    }
    public static String solution(String polynomial) {
        String[] questionList = polynomial.split(" ");
        int num = 0;
        int variable = 0;
        for(int i = 0; i < questionList.length; i+=2){
            if(questionList[i].contains("x")){
                if(questionList[i].length()==1){
                    variable += 1;
                }else{
                    variable += Integer.parseInt(questionList[i].substring(0,questionList[i].length()-1));
                }
            }else{
                num +=Integer.parseInt(questionList[i]);
            }
        }

        if(num == 0){
            if(variable == 1){
                return "x";
            }
            return variable+"x";
        }
        if(variable == 0){
            return String.valueOf(num);
        }
        if(variable == 1){
            return "x + "+num;
        }
        return variable+"x + "+num;
    }
}
