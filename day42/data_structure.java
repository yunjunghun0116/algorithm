import java.util.*;

public class data_structure {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            arrList.add(i);
        }
        arrList.sort((a,b)->a-b);
        for(int i : arrList){
            System.out.print(i+" ");
        }
        System.out.println();
        Collections.sort(arrList,(a,b)->b-a);
        for(int i : arrList){
            System.out.print(i+" ");
        }
        System.out.println();



        List<String> strList = new ArrayList<>();
        for(int i = 0; i <= 10; i++){
            char s = (char)('a'+i);
            String str = s+"hello"+i;
            strList.add(str);
        }
        strList.sort((a,b)->b.charAt(0)-a.charAt(0));
        for(String str : strList){
            System.out.print(str+" ");
        }
        System.out.println();
        Collections.sort(strList,(a,b)->b.length()-a.length());
        for(String str : strList){
            System.out.print(str+" ");
        }
        System.out.println();


        String[] strArr = {"sort","string","array","array2"};
        int[] intArr = {3,7,5,4,11,-3};
        Arrays.sort(strArr,Comparator.reverseOrder());
        Arrays.sort(strArr, (a,b)->b.length()-a.length());

        System.out.println(Arrays.toString(strArr));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);


        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        String[] strListToArray = strList.toArray(String[]::new);
        int[] arrListToArray = arrList.stream().mapToInt(Integer::intValue).toArray();
        List<Long> longList = new ArrayList<>();
        long[] longListToArray = longList.stream().mapToLong(Long::longValue).toArray();

        TreeSet<int[]> heap = new TreeSet<>((a,b)->b[0]-a[0]);
        TreeSet<Integer> tree = new TreeSet<>((a,b)->b-a);
        Map<Integer,Integer> numberMap = new HashMap<>();

    }
}
