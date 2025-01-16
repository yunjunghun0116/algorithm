

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Meet> meetList = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        int roomCount = findRoom();
        System.out.println(roomCount);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] meetInput = sc.nextLine().split(" ");
            Meet meet = new Meet(Integer.parseInt(meetInput[0]), Integer.parseInt(meetInput[1]));
            meetList.add(meet);
        }

        Collections.sort(meetList);
    }

    public static int findRoom() {
        int lastStart = Integer.MAX_VALUE;
        int count = 0;
        for (Meet meet : meetList) {
            if (meet.end <= lastStart) {
                lastStart = meet.start;
                count++;
            }
        }

        return count;
    }

    static class Meet implements Comparable<Meet> {
        int start;
        int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meet other) {
            if (other.start == this.start) {
                return other.end - this.end;
            }
            return other.start - this.start;
        }
    }
}

