public class bible4 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 10; i > 1;i --){
            int num = factorial(i);
            if(num<=n){
                return i;
            }
        }
        return answer;
    }
    public int factorial(int n){
        int result = 1;
        for(int i = n; i > 1; i--){
            result*=i;
        }
        return result;
    }
}
