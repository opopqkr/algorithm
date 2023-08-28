package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 50, 80}, 100));
        System.out.println(solution(new int[]{40, 50, 150, 60}, 200));
        System.out.println(solution(new int[]{100, 500, 500, 900, 950}, 1000));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        // 정렬
        Arrays.sort(people);
        Deque<Integer> deque = new LinkedList<>();
        for (int i : people) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            int first = deque.peekFirst();
            // 1. 제일 가벼운 사람과 제일 무거운 사람의 합이 보트의 무게 제한보다 클 경우,
            //    둘 다 동시에 보트에 태울 수 없기 때문에 제일 무거운 사람만 poll 하고 보트의 수 + 1 (조건 문 수행 x)
            int last = deque.pollLast();

            // 2. 제일 가벼운 사람과 제일 무거운 사람의 합이 보트의 무게 제한보다 작거나 같을 경우,
            //    둘 다 동시에 보트에 태울 수 있기 때문에 조건문에 의해 제일 가벼운 사람도 poll 하고 보트의 수 + 1 (조건 문 수행)
            if (first + last <= limit) {
                deque.pollFirst();
            }

            answer++;
        }

        return answer;
    }
}
