public class bible2 {
    public int solution(int n) {
        int result = 1;
        int six = 6;
        int number = n;
        int min = Math.min(n,6);
        for(int i = 2; i <= min; i++){
            if(six%i == 0 && number %i == 0){
                six = six/i;
                number = number/i;
                min = Math.min(six,number);
                result = result*i;
                i = 1;
            }
        }

        return (result*six*number)/6;
    }
}
