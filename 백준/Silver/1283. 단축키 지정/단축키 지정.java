import java.util.*;

public class Main {
    public static List<String> strings = new ArrayList<>();

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
        Set<Character> charSet = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        for (String string : strings) {
            if (string.isEmpty()) {
                resultList.add(string);
                continue;
            }
            String[] str = string.split(" ");
            String result = "";
            boolean isChanged = false;
            for (String s : str) {
                if (isChanged) {
                    if (result.isEmpty()) {
                        result = s;
                        continue;
                    }
                    result = result + " " + s;
                    continue;
                }
                if (!charSet.contains(Character.toUpperCase(s.charAt(0)))) {
                    charSet.add(Character.toUpperCase(s.charAt(0)));
                    String changedString = changeString(s, 0);
                    isChanged = true;
                    if (result.isEmpty()) {
                        result = changedString;
                        continue;
                    }
                    result = result + " " + changedString;
                    continue;
                }
                if (result.isEmpty()) {
                    result = s;
                    continue;
                }
                result = result + " " + s;
            }
            if (isChanged) {
                resultList.add(result);
                continue;
            }
            for (int i = 0; i < string.length(); i++) {
                if (isChanged) continue;
                if (string.charAt(i) == ' ') continue;
                if (!charSet.contains(Character.toUpperCase(string.charAt(i)))) {
                    charSet.add(Character.toUpperCase(string.charAt(i)));
                    String changedString = changeString(string, i);
                    resultList.add(changedString);
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
