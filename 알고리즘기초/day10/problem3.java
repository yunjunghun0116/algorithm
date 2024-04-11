public class problem3 {
    public String solution(String my_string, int s, int e) {
        String start = my_string.substring(0,s);
        String middle = "";
        String end = my_string.substring(e+1);
        for(int i = 0;i <e-s+1; i++){
            middle += my_string.charAt(e-i);
        }

        return start+middle+end;
    }
}
