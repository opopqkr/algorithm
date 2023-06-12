package study.dev.algorithm.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputs = in.next();
        System.out.println(solution1(inputs));
        System.out.println(solution2(inputs));
    }

    /**
     * 내 풀이
     *
     * @param inputs
     * @return
     */
    private static int solution1(String inputs) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (char input : inputs.toCharArray()) {
            if (Character.isDigit(input)) {
                stack.push(Integer.parseInt(Character.toString(input)));
            } else {
                if (!stack.isEmpty()) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(cal(a, b, input));
                }
            }
        }
        answer = stack.peek();
        return answer;
    }

    private static int cal(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }

    /**
     * 강의 풀이
     * <p>
     * ASCII 0 = 48
     *
     * @param inputs
     * @return
     */
    private static int solution2(String inputs) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (char input : inputs.toCharArray()) {
            if (Character.isDigit(input)) {
                stack.push(input - 48);
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if (input == '+') {
                    stack.push(a + b);
                } else if (input == '-') {
                    stack.push(a - b);
                } else if (input == '*') {
                    stack.push(a * b);
                } else if (input == '/') {
                    stack.push(a / b);
                }
            }
        }
        answer = stack.get(0);
        return answer;
    }
}
