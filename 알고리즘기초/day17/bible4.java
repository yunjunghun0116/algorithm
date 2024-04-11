public class bible4 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String[] quizArr = quiz[i].split(" ");
            int value = Integer.parseInt(quizArr[0]) + (Integer.parseInt(quizArr[2]) * (quizArr[1].equals("+") ? 1 : -1));
            answer[i] = value == Integer.parseInt(quizArr[4]) ? "O" : "X";
        }
        return answer;
    }
}
