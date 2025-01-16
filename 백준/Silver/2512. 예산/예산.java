

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int budget;
    public static List<Integer> personalBudgetList = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        int result = findMaxBudget();
        System.out.println(result);
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        for (String budget : sc.nextLine().split(" ")) {
            personalBudgetList.add(Integer.parseInt(budget));
        }

        personalBudgetList.sort(Comparator.comparingInt(a -> a));
        budget = Integer.parseInt(sc.nextLine());
    }

    public static int findMaxBudget() {
        if (checkGiveAll()) {
            return personalBudgetList.get(personalBudgetList.size() - 1);
        }
        int left = 0;
        int right = budget;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            int usedBudget = getBudget(mid);
            if (usedBudget == budget) return mid;
            if (usedBudget > budget) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        return (left + right) / 2;
    }

    public static int getBudget(int money) {
        int usedBudget = 0;

        for (int personalBudget : personalBudgetList) {
            usedBudget += Math.min(personalBudget, money);
        }

        return usedBudget;
    }

    public static boolean checkGiveAll() {
        int money = 0;
        for (int personalBudget : personalBudgetList) {
            money += personalBudget;
        }
        return money <= budget;
    }
}
