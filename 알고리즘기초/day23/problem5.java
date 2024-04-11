public class problem5 {
    public int solution(int[] date1, int[] date2) {
        if(date2[0]>date1[0]) return 1;
        if(date2[0]==date1[0] && date2[1]>date1[1]) return 1;
        if(date2[0]==date1[0] && date2[1]==date1[1] && date2[2]>date1[2]) return 1;
        return 0;
    }
}
