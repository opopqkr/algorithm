package study.dev.algorithm.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {

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

        Stack<Character> stack = new Stack<>();
        char[] inputArray = inputs.toCharArray();

        for (int i = 0; i < inputArray.length; i++) {
            if (inputs.charAt(i) == '(') {
                stack.push(inputs.charAt(i));
            } else {
                stack.pop();
                if (inputs.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param inputs
     * @return
     */
    private static int solution2(String inputs) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputs.length(); i++) {
            if (inputs.charAt(i) == '(') {
                stack.push(inputs.charAt(i));
            } else {
                stack.pop();
                if (inputs.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
}
