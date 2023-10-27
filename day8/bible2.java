public class bible2 {
    public String solution(int age) {
        String answer = "";
        char[] ageArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        String ageString = String.valueOf(age);
        for (int i = 0; i < ageString.length(); i++) {
            int index = Integer.parseInt(String.valueOf(ageString.charAt(i)));
            answer += ageArray[index];
        }

        return answer;
    }
}
