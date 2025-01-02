public class problem2 {
    public int solution(int n) {
        int ans = 0;

        while(n>0){
            if(n%2==0){
                n/=2;
                continue;
            }
            n--;
            ans++;
        }

        return ans;
    }
}
