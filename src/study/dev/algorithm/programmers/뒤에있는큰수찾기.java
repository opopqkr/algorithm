package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {

    public static void main(String[] args) {
        Arrays.stream(solution(new int[]{2, 3, 3, 5})).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new int[]{9, 1, 5, 3, 6, 2})).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
}
