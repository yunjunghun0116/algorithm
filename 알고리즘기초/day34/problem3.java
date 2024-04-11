import java.util.*;
import java.util.regex.*;

public class problem3 {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }

    public static long solution(String expression) {
        boolean[] visited = new boolean[3];
        permutation("", visited, new char[]{'+', '*', '-'}, 3);

        long value = Long.MIN_VALUE;

        for (String str : result) {
            String strExpression = expression;
            for (int i = 0; i < 3; i++) {
                strExpression = setString(strExpression, str.charAt(i));
            }
            if (strExpression.startsWith("m")) {
                value = Math.max(value, Math.abs(((-1) * Long.valueOf(strExpression.substring(1)))));
                continue;
            }

            value = Math.max(value, Math.abs(Long.valueOf(strExpression)));
        }
        return value;
    }

    public static String setString(String string, char operator) {
        String regExp = "((m?)(\\d+)([" + operator + "])(m?)(\\d+))";
        Pattern pattern = Pattern.compile(regExp);

        String tempString = string;
        Matcher matchers = pattern.matcher(tempString);

        while (matchers.find()) {
            int startIndex = matchers.start();
            int length = matchers.group().length();
            String operationString = matchers.group();

            String[] splitString = operationString.split("[*+-]");

            long value;
            long firstValue = splitString[0].startsWith("m") ? (-1) * Long.valueOf(splitString[0].substring(1)) : Long.valueOf(splitString[0]);
            long secondValue = splitString[1].startsWith("m") ? (-1) * Long.valueOf(splitString[1].substring(1)) : Long.valueOf(splitString[1]);
            switch (operator) {
                case '+': {
                    value = firstValue + secondValue;
                    break;
                }
                case '*': {
                    value = firstValue * secondValue;
                    break;
                }
                case '-':
                default: {
                    value = firstValue - secondValue;
                    break;
                }
            }
            tempString = tempString.substring(0, startIndex) + (value < 0 ? "m" : "") + Math.abs(value) + (startIndex + length == tempString.length() ? "" : tempString.substring(startIndex + length));
            matchers = pattern.matcher(tempString);
        }

        return tempString;
    }


    public static void permutation(String preStr, boolean[] visited, char[] chars, int length) {
        if (preStr.length() == length) {
            result.add(preStr);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permutation(preStr + chars[i], visited, chars, length);
            visited[i] = false;
        }
    }

}
