public class problem3 {
    public int solution(String binomial) {
        String[] quiz = binomial.split(" ");
        if(quiz[1].equals("*")){
            return Integer.parseInt(quiz[0])*Integer.parseInt(quiz[2]);
        }
        if(quiz[1].equals("+")){
            return Integer.parseInt(quiz[0])+Integer.parseInt(quiz[2]);
        }
        return Integer.parseInt(quiz[0])-Integer.parseInt(quiz[2]);
    }
}
