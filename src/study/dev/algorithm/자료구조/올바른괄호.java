package study.dev.algorithm.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println(solution1(input));
        System.out.println(solution2(input));
    }

    /**
     * 내 풀이
     *
     * @param input
     * @return
     */
    private static String solution1(String input) {
        String answer = "YES";

        Stack<Character> stack = new Stack<>();
        for (char item : input.toCharArray()) {
            if (item == '(') {
                stack.push(item);
            } else {
                if (stack.size() == 0) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() != 0) {
            answer = "NO";
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param input
     * @return
     */
    private static String solution2(String input) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char item : input.toCharArray()) {
            if (item == '(') {
                stack.push(item);
            } else {
                // 닫는 괄호 ')' 가 많은 상황
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }

        // 여는 괄호 '(' 가 많은 상황
        if (!stack.isEmpty()) {
            return "NO";
        }

        return answer;
    }
}
