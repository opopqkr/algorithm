package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식 {

    /**
     * INPUT
     * <p>
     * 1. A*(B+C)
     * 2. A+B
     * 3. A+B*C
     * 4. A+B*C-D/E
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(solution(input));
    }

    private static String solution(String input) {
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (char temp : input.toCharArray()) {
            if (Character.isAlphabetic(temp)) {
                answer.append(temp);
            } else {
                if (temp == '(') {
                    stack.push(temp);
                } else if (temp == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        answer.append(stack.pop());
                    }
                    // '(' 제거
                    stack.pop();
                } else {
                    // 현재 연산자가 stack.peek() 보다 우선 순위가 작거나 같을 떄까지 answer.append()
                    // 즉, 중위 표현식에서 곱하기 혹은 나누기 연산자 뒤에 더하기 혹은 빼기 연산자가 있을 경우.
                    while (!stack.isEmpty() && getPriority(temp) <= getPriority(stack.peek())) {
                        answer.append(stack.pop());
                    }
                    stack.push(temp);
                }
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.toString();
    }

    private static int getPriority(char operation) {
        switch (operation) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }

        return 0;
    }
}
