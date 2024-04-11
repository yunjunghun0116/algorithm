import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제대로 주어진 코드는 괜찮지만 메모리사용량과 실행속도가 너무 오래걸려서 다른 개선방식이 없을까? 고민하다가 생각난 해결방법
public class problem2_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        StringBuilder stringBuilder = new StringBuilder();
        int l = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());

        int[] result = solution(l, r);

        for (int number : result) {
            stringBuilder.append(number + " ");
        }
    }

    public static int[] solution(int l, int r) {
        int start = -1;
        int end = -1;

        int currentNumber = 0;
        while (start == -1 || end == -1) {
            if (getBinaryNumber(currentNumber) * 5 >= l && start == -1) {
                start = currentNumber;
            }
            if (end == -1) {
                if (getBinaryNumber(currentNumber) * 5 == r) {
                    end = currentNumber;
                    break;
                }
                if (getBinaryNumber(currentNumber) * 5 > r) {
                    end = currentNumber - 1;
                    break;
                }
            }
            currentNumber++;
        }

        int[] result = new int[end - start + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = getBinaryNumber((start + i)) * 5;
        }

        if (result.length == 0) {
            int[] emptyArray = {-1};
            return emptyArray;
        }

        return result;
    }

    public static int getBinaryNumber(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        String result = "0";
        int subNumber = number;
        int powCount = 0;
        while (subNumber > 1) {
            if (Math.pow(2, powCount + 1) == subNumber) {
                powCount = powCount + 1;

                String tempStr = "1";
                for (int i = 0; i < powCount; i++) {
                    tempStr += "0";
                }
                result = String.valueOf(Integer.parseInt(result) + Integer.parseInt(tempStr));
                break;
            }
            if (Math.pow(2, powCount + 1) > subNumber) {
                String tempStr = "1";
                for (int i = 0; i < powCount; i++) {
                    tempStr += "0";
                }
                result = String.valueOf(Integer.parseInt(result) + Integer.parseInt(tempStr));

                subNumber = subNumber % (int) Math.pow(2, powCount);
                powCount = 0;

                continue;
            }
            powCount++;
        }
        if (subNumber == 1) {
            result = String.valueOf(Integer.parseInt(result) + 1);
        }

        return Integer.parseInt(result);
    }

    public static int getBinaryNumber2(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        String str = "";
        int tempNumber = number;

        while (tempNumber / 2 != 0) {
            str += (tempNumber % 2);
            tempNumber = tempNumber / 2;
        }
        str += "1";

        String reversedString = "";
        for (int i = 0; i < str.length(); i++) {
            reversedString += str.charAt(str.length() - 1 - i);
        }


        return Integer.parseInt(reversedString);
    }
}
