import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Member> members = new ArrayList<>();
    static int n;

    static void input() {
        var sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            var input = sc.nextLine().split(" ");
            var member = new Member(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            members.add(member);
        }
    }

    static void solution() {
        Collections.sort(members);
        for (var member : members) {
            System.out.println(member.getName());
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class Member implements Comparable<Member> {
        private String name;
        private int korean;
        private int english;
        private int math;

        public String getName() {
            return name;
        }

        public Member(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public int compareTo(Member other) {
            if (korean != other.korean) {
                return other.korean - korean;
            }
            if (english != other.english) {
                return english - other.english;
            }
            if (math != other.math) {
                return other.math - math;
            }
            return name.compareTo(other.name);
        }
    }
}
