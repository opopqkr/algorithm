package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {

    /**
     * INPUT
     * <p>
     * mirkovC4nizCC44
     * C4
     * <p>
     * 12ab112ab2ab
     * 12ab
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine(), explosionString = br.readLine();
        int explosionLength = explosionString.length();

        // replace all 해결 방법은 메모리, 시간 초과
        // stack 이용.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));

            if (stack.size() >= explosionLength) {
                boolean isExplosion = true;

                for (int j = 0; j < explosionLength; j++) {
                    if (stack.get(stack.size() - explosionLength + j) != explosionString.charAt(j)) {
                        isExplosion = false;
                        break;
                    }
                }

                if (isExplosion) {
                    for (int j = 0; j < explosionLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char word : stack) stringBuilder.append(word);

        System.out.println(stringBuilder.length() > 0 ? stringBuilder.toString() : "FRULA");
    }
}
