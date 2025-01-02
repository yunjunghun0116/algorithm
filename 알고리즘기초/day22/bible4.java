public class bible4 {
    public static void main(String[] args) {
        System.out.println("solution(11,22) = " + solution(7,20));
    }
    public static int solution(int a, int b) {
        int divisor = getDivisor(a,b);
        int num2 = b/divisor;
        while(num2%5==0){
            num2 = num2/5;
        }
        while(num2%2==0){
            num2 = num2/2;
        }
        return num2==1?1:2;
    }
    public static int getDivisor(int a,int b){
        int divisor = 1;
        int num1 = a;
        int num2 = b;
        int div = 2;
        while(num1 > 1 && num2 > 1){
            if(div > num1 || div > num2) break;
            if(num1%div == 0 && num2%div==0){
                num1 = num1/div;
                num2 = num2/div;
                divisor *=div;
                div = 2;
                continue;
            }
            div++;
        }
        return divisor;
    }
}
