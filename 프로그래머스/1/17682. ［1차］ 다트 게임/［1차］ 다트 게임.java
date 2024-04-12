import java.util.Stack;

class Solution {
  public int solution(String dartResult) {
    Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int a = 0; a < dartResult.length(); a++) {
            if (dartResult.charAt(a) == '#') {
                int num = stack.pop();

                stack.push(num*-1);
            }
            else if (dartResult.charAt(a) == '*') {
                int num = stack.pop();
                int num2 = stack.pop();
                stack.push(num2*2);
                stack.push(num*2);
            }
            else if (dartResult.charAt(a) == 'S') {
                int num = stack.pop();
                stack.push(num);
            }
            else if (dartResult.charAt(a) == 'D') {
                int num = stack.pop();
                stack.push(num*num);
            }
            else if (dartResult.charAt(a) == 'T') {
                int num = stack.pop();
                stack.push(num*num*num);
            }else {
                int num = Integer.parseInt(String.valueOf(dartResult.charAt(a)));
                char num2 = dartResult.charAt(a+1);
                if(num==1 && num2=='0') {
                    stack.push(10);
                    a=a+1;
                }else {
                    stack.push(Integer.parseInt(String.valueOf(dartResult.charAt(a))));
                }
            }
        }
         int answer = stack.pop()+stack.pop()+stack.pop();
         return answer;
  }
}