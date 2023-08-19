package study.dev.algorithm.programmers;

import java.util.Stack;

public class 택배상자 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }

    public static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int orderIndex = 0;
        for (int currentBox = 1; currentBox <= order.length; currentBox++) {
            if (currentBox == order[orderIndex]) {
                answer++;
                orderIndex++;
                while (!stack.isEmpty() && stack.peek() == order[orderIndex]) {
                    answer++;
                    orderIndex++;
                    stack.pop();
                }
            } else {
                stack.push(currentBox);
            }
        }

        return answer;
    }
}
