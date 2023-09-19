package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 더맵게 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int k) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue
                = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll();

            if (current < k) {
                if (priorityQueue.isEmpty()) {
                    return -1;
                }

                // 두 번째로 맵지 않은 음식 poll()
                current += (priorityQueue.poll() * 2);
                priorityQueue.offer(current);
                answer++;
            }
        }

        return answer;
    }
}
