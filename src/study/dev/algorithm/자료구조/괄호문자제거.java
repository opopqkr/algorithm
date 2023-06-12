package study.dev.algorithm.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {

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
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for (char item : input.toCharArray()) {
            stack.push(item);
            if (item == ')') {
                while (!stack.isEmpty()) {
                    if (stack.pop() == '(') {
                        break;
                    }
                }
            }
        }

        for (char item : stack) {
            answer += item;
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
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for (char item : input.toCharArray()) {
            if (item == ')') {
                while (stack.pop() != '(') ;
            } else {
                stack.push(item);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }
}
