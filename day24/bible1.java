public class bible1 {
    public int solution(int chicken) {
        int num = chicken;
        int coupons = 0;
        while(num>=10){
            int coupon = num/10;
            num = num%10 + coupon;
            coupons+=coupon;
        }
        return coupons;
    }
}
