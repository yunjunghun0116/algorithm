public class bible1 {
    public int solution(int[] dot) {
        if(dot[0]*dot[1] > 0){
            if(dot[0]>0) return 1;
            return 3;
        }
        if(dot[0]>0) return 4;
        return 2;
    }
}
