import java.util.*;

public class Main {
    public static List<String> strings = new ArrayList<>();
    public static Set<Character> charSet = new HashSet<>();

    public static void main(String[] args) {
        initialize();
        solve();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            strings.add(sc.nextLine());
        }
    }

    public static void solve() {
        List<String> resultList = new ArrayList<>();

        for (String string : strings) {
            String[] str = string.split(" ");
            String result = "";
            boolean isChanged = false;
            for (String s : str) {
                if (isChanged) {
                    result = addString(result, s);
                    continue;
                }
                String addString = canAddChar(s, 0);
                if (!addString.isEmpty()) {
                    isChanged = true;
                    result = addString(result, addString);
                    continue;
                }
                result = addString(result, s);
            }
            if (isChanged) {
                resultList.add(result);
                continue;
            }
            for (int i = 0; i < string.length(); i++) {
                if (isChanged) continue;
                if (string.charAt(i) == ' ') continue;
                String addString = canAddChar(string, i);
                if (!addString.isEmpty()) {
                    resultList.add(addString);
                    isChanged = true;
                }
            }
            if (!isChanged) {
                resultList.add(string);
            }
        }

        print(resultList);
    }

    public static void print(List<String> result) {
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String addString(String prev, String nextString) {
        if (prev.isEmpty()) {
            return nextString;
        }
        return prev + " " + nextString;
    }

    public static String canAddChar(String string, int idx) {
        if (charSet.contains(Character.toUpperCase(string.charAt(idx)))) return "";
        charSet.add(Character.toUpperCase(string.charAt(idx)));
        return changeString(string, idx);
    }

    public static String changeString(String str, int idx) {
        String result;
        if (idx == 0) {
            result = "[" + str.charAt(idx) + "]" + str.substring(1);
            return result;
        }
        result = str.substring(0, idx) + "[" + str.charAt(idx) + "]" + str.substring(idx + 1);
        return result;
    }
}
