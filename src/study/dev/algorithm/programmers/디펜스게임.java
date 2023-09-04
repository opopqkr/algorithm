package study.dev.algorithm.programmers;

import java.util.PriorityQueue;

public class 디펜스게임 {

    public static void main(String[] args) {
        System.out.println(solution(7, 4, new int[]{4, 2, 4, 5, 3, 3, 1}));
        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
        // 반례
        // System.out.println(solution(10, 3, new int[]{12, 11, 4, 2, 1, 5, 8, 6, 7}));
        // System.out.println(solution(5, 2, new int[]{99, 1, 99}));
        // System.out.println(solution(7, 1, new int[]{2, 1, 5, 2}));
        // System.out.println(solution(7, 2, new int[]{2, 1, 99, 99}));

    }

    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int step = 0; step < enemy.length; step++) {
            priorityQueue.offer(enemy[step]);

            if (priorityQueue.size() > k) {
                n -= priorityQueue.poll();
            }

            if (n < 0) {
                return step;
            }
        }

        return enemy.length;
    }
}
