import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        initialize();
        System.out.println(solve());
    }

    public static void initialize() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (s > e) list.add(new int[]{s, e});
        }
        list.sort((a, b) -> Integer.compare(b[0], a[0]));
    }

    public static long solve() {
        long dist = M;
        int i = 0;
        while (i < list.size()) {
            int maxS = list.get(i)[0];
            int minE = list.get(i)[1];
            int j = i;
            while (j + 1 < list.size() && list.get(j + 1)[0] >= minE) {
                j++;
                minE = Math.min(minE, list.get(j)[1]);
            }
            dist += 2L * (maxS - minE);
            i = j + 1;
        }
        return dist;
    }
}
