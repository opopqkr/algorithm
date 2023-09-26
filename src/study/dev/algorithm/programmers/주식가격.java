package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        Arrays.stream(solutionByStack(new int[]{1, 2, 3, 2, 3})).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solutionByForLoop(new int[]{1, 2, 3, 1, 1, 3})).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solutionByStack(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int currentTime = 0; currentTime < prices.length; currentTime++) {
            while (!stack.isEmpty()) {
                int beforeTime = stack.peek();
                if (prices[beforeTime] > prices[currentTime]) {
                    answer[beforeTime] = currentTime - beforeTime;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(currentTime);
        }

        while (!stack.isEmpty()) {
            int time = stack.pop();
            answer[time] = prices.length - time - 1;
        }

        return answer;
    }

    public static int[] solutionByForLoop(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }
}
