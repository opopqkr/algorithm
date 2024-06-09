package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 에디터 {

    /**
     * INPUT
     * <p>
     * abcd
     * 3
     * P x
     * L
     * P y
     * <p>
     * abc
     * 9
     * L
     * L
     * L
     * L
     * L
     * P x
     * L
     * B
     * P y
     * <p>
     * dmih
     * 11
     * B
     * B
     * P x
     * L
     * B
     * B
     * B
     * P y
     * D
     * D
     * P z
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Editor editor = new Editor(input);

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String order = br.readLine();
            char function = order.charAt(0);
            if (function == 'L') {
                editor.moveLeft();
            } else if (function == 'D') {
                editor.moveRight();
            } else if (function == 'B') {
                editor.delete();
            } else if (function == 'P') {
                editor.insert(order.charAt(2));
            }
        }

        editor.print();
    }

    private static class Editor {
        Stack<Character> stack, queue;

        public Editor(String init) {
            stack = new Stack<>();
            queue = new Stack<>();
            for (char word : init.toCharArray()) {
                stack.push(word);
            }
        }

        public void moveLeft() {
            if (!stack.isEmpty()) queue.push(stack.pop());
        }

        public void moveRight() {
            if (!queue.isEmpty()) stack.push(queue.pop());
        }

        public void delete() {
            if (!stack.isEmpty()) stack.pop();
        }

        public void insert(char word) {
            stack.push(word);
        }

        public void print() {
            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }

            StringBuilder sb = new StringBuilder();
            for (Character character : stack) {
                sb.append(character);
            }

            System.out.print(sb);
        }
    }
}
