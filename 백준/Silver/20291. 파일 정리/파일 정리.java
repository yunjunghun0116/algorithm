import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // 20291 15970
    static Map<String, Integer> extensionsMap = new HashMap<>();

    static void input() {
        var sc = new Scanner(System.in);
        var n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            var input = sc.nextLine();
            var extStartPos = input.indexOf('.');
            var extension = input.substring(extStartPos + 1);
            extensionsMap.put(extension, extensionsMap.getOrDefault(extension, 0) + 1);
        }
    }

    static void solution() {
        var result = new ArrayList<Extension>();
        for (var extension : extensionsMap.entrySet()) {
            result.add(new Extension(extension.getKey(), extension.getValue()));
        }

        Collections.sort(result, (a, b) -> a.ext.compareTo(b.ext));

        for (var ext : result) {
            System.out.println(ext.ext + " " + ext.cnt);
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class Extension {
        String ext;
        int cnt;

        public Extension(String ext, int cnt) {
            this.ext = ext;
            this.cnt = cnt;
        }
    }
}
