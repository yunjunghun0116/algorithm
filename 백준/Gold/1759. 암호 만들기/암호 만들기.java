import java.util.*;

public class Main {
    static int L, C;
    static Set<Character> moeumSet = new HashSet<>();
    static List<Character> wordList = new ArrayList<>();
    static List<Character> tempList = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        solve(0);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        L = Integer.parseInt(sizeInput[0]);
        C = Integer.parseInt(sizeInput[1]);

        moeumSet.add('a');
        moeumSet.add('e');
        moeumSet.add('i');
        moeumSet.add('o');
        moeumSet.add('u');

        String[] words = sc.nextLine().split(" ");
        for (String word : words) {
            wordList.add(word.charAt(0));
        }

        wordList.sort((a, b) -> (a - '0') - (b - '0'));
    }

    public static void solve(int lastIndex) {
        if (tempList.size() == L) {
            int moeumCnt = 0;
            for (char c : tempList) {
                if (moeumSet.contains(c)) {
                    moeumCnt++;
                }
            }
            if (moeumCnt > 0 && (L - moeumCnt) > 1) {
                for (char c : tempList) {
                    System.out.print(String.valueOf(c));
                }
                System.out.println();
            }
            return;
        }
        if (lastIndex >= C) return;
        // 길이 L 만큼 cCl 을 하면 된다.
        // 조합, combination 을 하면 된다.
        tempList.add(wordList.get(lastIndex));
        solve(lastIndex + 1);
        tempList.remove(tempList.size() - 1);
        solve(lastIndex + 1);
    }

}
